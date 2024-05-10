package com.codingdojo.musicZone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.musicZone.models.Artist;
import com.codingdojo.musicZone.services.ArtistService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	private final ArtistService aService;
	
	public HomeController(ArtistService aService) {
		this.aService = aService;
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("artist") Artist artist){
		model.addAttribute("artists", aService.allArtists());
		return "index.jsp";
	}
	
	@PostMapping("/newArtist")
	public String createNewArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("artists", aService.allArtists());
			return "index.jsp";
		}else {
			aService.newArtist(artist);
			return "redirect:/";
		}
		
	}
	@GetMapping("/artist/{id}")
	public String getOneArtist(Model model, @PathVariable("id") Long id) {
		Artist artist = aService.oneArtist(id);
		model.addAttribute(artist);
		return "oneArtist.jsp";
	}
	@DeleteMapping("artist/delete/{id}")
	public String deleteArtistById(@PathVariable("id") Long id) {
		aService.deleteArtist(id);
		return "redirect:/";
	}
	
}
