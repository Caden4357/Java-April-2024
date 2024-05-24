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

import com.codingdojo.mockexam.models.Artist;
import com.codingdojo.mockexam.models.Comment;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.services.ArtistService;
import com.codingdojo.mockexam.services.CommentService;
import com.codingdojo.mockexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	ArtistService artists;
	@Autowired
	UserService users;
	@Autowired
	HttpSession session;
	@Autowired
	CommentService comments;
	
	@GetMapping("/artist/form")
	public String artistForm(@ModelAttribute("artist") Artist artist) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		return "artistForm.jsp";
	}
	@PostMapping("/create/artist")
	public String createArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult result) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "artistForm.jsp";
		}
		else {
			User user = users.getUserById(userId);
			artist.setUser(user);
			artists.newArtist(artist);
		}
		return "redirect:/homepage";
	}
	
	
	@GetMapping("/view/artist/{id}")
	public String viewArtist(@PathVariable("id") Long id, Model model, @ModelAttribute("comment") Comment comment) {
		model.addAttribute("artist", artists.findArtist(id));
		return "viewArtist.jsp";
	}
	
	@PostMapping("/create/comment/{artistId}")
	public String createComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, Model model, @PathVariable("artistId") Long artistId) {
		Long userId = (Long) session.getAttribute("userId");
		Artist artist = artists.findArtist(artistId);
		User user = users.getUserById(userId);
		comment.setUser(user);
		comment.setArtist(artist);
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			model.addAttribute("artist", artist);
			return "viewArtist.jsp";
		}
		else {
			comments.newComment(comment);
			return "redirect:/view/artist/" + artistId;
		}
	}
	
	@DeleteMapping("/delete/artist/{id}")
	public String deleteArtist(@PathVariable("id") Long id) {
		artists.deleteArtist(id);
		return "redirect:/homepage";
	}
	@GetMapping("/edit/artist/{id}")
	public String editArtist(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artist", artists.findArtist(id));
		return "editArtist.jsp";
	}
	@PutMapping("/update/artist/{id}")
	public String updateArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult result, Model model, @PathVariable("id") Long id) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			model.addAttribute("artist", artists.findArtist(id));
			return "editArtist.jsp";
		}else {
			User user = users.getUserById(userId);
			artist.setUser(user);
			artists.updateArtist(artist);
			return "redirect:/homepage";
		}
	}
}
