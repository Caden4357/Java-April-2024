package com.codingdojo.ninjaGold.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ninjaGold.models.Note;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class HomeController {
//	!!!!!!! still need notes/activities
//	!!!!!!! we need a date formatter for the notes 
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activities") == null) {
			ArrayList<Note> activitiesList = new ArrayList<Note>(); 
			session.setAttribute("activities", activitiesList);
		}
		return "index.jsp";
	}
	
	@PostMapping("/getGold")
	public String getGold(@RequestParam("location") String location, HttpSession session) {
//		updating gold amount 
		int usersCurrentTotalGold = (int) session.getAttribute("gold");
		int earnedGoldThisTurn = generateGold(location);
		usersCurrentTotalGold += earnedGoldThisTurn;
		session.setAttribute("gold", usersCurrentTotalGold);
		
//		updating users notes
		ArrayList<Note> currentNotes = (ArrayList<Note>) session.getAttribute("activities");
		Note newNote = generateActivityNote(location, earnedGoldThisTurn);
		currentNotes.add(newNote);
		session.setAttribute("activities", currentNotes);
//		need to create a message for each event/turn
		return "redirect:/";
		
	}
	@PostMapping("/reset")
	public String resetGame(HttpSession session) {
		session.setAttribute("gold", 0);
		return "redirect:/";
	}
	
//	generating an activity note 
//	generateActivity(location, earnedGoldThisTurn)
//	generate a time stamp 
//	if earnedGoldThisTurn < 0 make the styleClass red (text-danger) bootstrap if its positive we style the text green
//	generate an activity string ex. "you entered " + location + " and earned " + earnedGoldThisTurn + " " + timeStamp
	public Note generateActivityNote(String location, int earnedGoldThisTurn) {
		Date timeStamp = new Date();
		System.out.println(timeStamp);
		Note newNote = new Note();
		String noteString;
		if(earnedGoldThisTurn < 0) {
			noteString = "your quest was not fruitful. Dont give up you lost  " + earnedGoldThisTurn + " " + timeStamp;
			newNote.setNote(noteString);
			newNote.setStyleClass("text-danger");
		}
		else {
			noteString = "you entered " + location + " and earned " + earnedGoldThisTurn + " " + timeStamp;
			newNote.setNote(noteString);
			newNote.setStyleClass("text-success");
		}
		return newNote;
 	}
	
	public int generateGold(String location) {
		Random random = new Random();
//		switch statement to check location to see which form the user submitted/clicked
		switch (location) {
		case "farm":return random.nextInt(11) + 10;
		case "cave":return random.nextInt(6) + 5;
		case "house":return random.nextInt(4) + 2;
		case "quest":return random.nextInt(101) - 50;
		default:return 0;
		}
	}
}
