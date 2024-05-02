package com.codingdojo.userlist.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.userlist.models.User;

@Controller
public class HomeController {
	
//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("item", "Whopper");
//		return "index.jsp";
//	}
	
	@GetMapping("/")
	public String index(Model model) {
		ArrayList<User> usersArrayList = new ArrayList<>();
		usersArrayList.add(new User("Shane", 25, true));
		usersArrayList.add(new User("Crystal", 40, true));
		usersArrayList.add(new User("Hanz", 34, true));
		usersArrayList.add(new User("Emerson", 2, false));
		model.addAttribute("users", usersArrayList);
		return "index.jsp";
	}
	
	
//	[user@12323, user@4543545]
}
