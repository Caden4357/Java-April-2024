package com.codingdojo.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	UserService users;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		return "index.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		users.register(newUser, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/";
	}
}
