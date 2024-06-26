package com.codingdojo.mockexam.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mockexam.models.LoginUser;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.services.BandService;
import com.codingdojo.mockexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	UserService users;
	@Autowired
	BandService bands;
	 @GetMapping("/")
	 public String index(Model model) {
	 
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	 }
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     users.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         // Be sure to send in the empty LoginUser before 
	         // re-rendering the page.
	         model.addAttribute("newLogin", new LoginUser());
	         return "index.jsp";
	     }
	     
	     session.setAttribute("userId", newUser.getId());
	 
	     return "redirect:/welcome";
	 }
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     // Add once service is implemented:
	     User user = users.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	 
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/welcome";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.setAttribute("userId", null);
		 return "redirect:/";
	 }
	 
	 @GetMapping("/welcome")
	 public String homepage(Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 if(userId==null) {
			 return "redirect:/";
		 }
		 User user = users.findById(userId);
		 
		 model.addAttribute("user",user);
		 model.addAttribute("bands", bands.getAllBandsOrderedByGenre());
		 return "welcome.jsp";
	 }
}