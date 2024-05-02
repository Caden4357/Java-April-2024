package com.codingdojo.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
//	@GetMapping("/")
//	public String index() {
//		return "redirect:/daikichi";
//	}
	
	@GetMapping("/daikichi")
	public String daikichi() {
		return "Welcome";
	}
	
	@GetMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@GetMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
}
