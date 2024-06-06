package com.codingdojo.mockexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mockexam.models.Band;
import com.codingdojo.mockexam.models.Comment;
import com.codingdojo.mockexam.models.Musician;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.services.BandService;
import com.codingdojo.mockexam.services.CommentService;
import com.codingdojo.mockexam.services.MusicianService;
import com.codingdojo.mockexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	UserService users;
	@Autowired
	BandService bands;
	@Autowired
	CommentService comments;
	@Autowired
	MusicianService musicians;
	
	@GetMapping("/band/form")
	public String bandForm(@ModelAttribute("band") Band band) {
		return "bandForm.jsp";
	}
	@PostMapping("/create/band")
	public String createBand(@Valid @ModelAttribute("band") Band band, BindingResult result) {
		System.out.println(band.getUser());
		if(result.hasErrors()) {
			return "bandForm.jsp";
		}
		else {
			bands.createBand(band);
			return "redirect:/welcome";
			
		}
	}
	@GetMapping("/view/band/{id}")
	public String viewBand(@PathVariable("id") Long id, Model model, @ModelAttribute("comment") Comment comment) {
		model.addAttribute("band", bands.oneBand(id));
		model.addAttribute("musicians", musicians.allMusicians());
		return "oneBand.jsp";
	}
	
	@PostMapping("/add/musician/to/band/{bandId}")
	public String addMusicianToBand(@PathVariable("bandId") Long bandId, @RequestParam("musicianId") Long musicianId) {
		Band band = bands.oneBand(bandId);
		Musician musician = musicians.findMusician(musicianId);
		bands.addMusicianToBand(musician, band);
		return "redirect:/view/band/" + bandId;
	}
	
	@PostMapping("/create/comment/{bandId}")
	public String createComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, @PathVariable("bandId") Long bandId, Model model, HttpSession session) {
		Band band = bands.oneBand(bandId);
		Long userId = (Long) session.getAttribute("userId");
		User user = users.findById(userId);
		comment.setBand(band);
		comment.setUser(user);
		if(result.hasErrors()) {
			model.addAttribute("artist", band);
			return "oneBand.jsp";
		}
		else {
			comments.createComment(comment);
			return "redirect:/view/band/" + bandId;
		}
	}
	
	@GetMapping("/edit/band/{id}")
	public String editBand(@PathVariable("id") Long id, Model model) {
		Band band = bands.oneBand(id);
		System.out.println("Band genre: " + band.getGenre());
		model.addAttribute("band", band);
		return "editBand.jsp";
	}
	@PutMapping("/update/band/{id}")
	public String updateBand(@Valid @ModelAttribute("band") Band band, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("band", bands.oneBand(id));
			return "editBand.jsp";
		} else { 
			Long userId = (Long) session.getAttribute("userId");
			User user = users.findById(userId);
			band.setUser(user);
			bands.updateBand(band);
			return "redirect:/welcome";
		}
	}
	@DeleteMapping("/delete/band/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		bands.deleteBand(id);
		return "redirect:/welcome";
	}
	
}
