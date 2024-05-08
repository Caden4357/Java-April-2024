package com.codingdojo.ninjaGold.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
//	!!!!!!! still need notes/activities
//	!!!!!!! we need a date formatter for the notes 
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	@PostMapping("/getGold")
	public String getGold(@RequestParam("location") String location) {
		Random random = new Random();
//		switch statement to check location to see which form the user submitted/clicked
		switch (location) {
		case "farm":
//			do some logic
			System.out.println(random.nextInt(20-10+1) + 10); // !! STOP HERE
			break;
		case "cave":
//			do some logic
			System.out.println("CAVE!!!");
			break;
		case "house":
//			do some logic
			System.out.println("HOUSE!!!");
			break;
		case "quest":
//			do some logic
			System.out.println("QUEST!!!");
			break;
		default:
			break;
		}
//		then update the users total gold 
//		need to create a message for each event/turn
		return "redirect:/";
		
	}
}
