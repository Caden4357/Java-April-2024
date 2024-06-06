package com.codingdojo.fileupload.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.fileupload.services.UploadService;

@Controller
public class HomeController {
	@Autowired
	UploadService imageService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("images", imageService.loadAll());
		return "index.jsp";
	}
	@PostMapping("/upload")
	public String uploadPhoto(@RequestParam("image") MultipartFile image) {
		imageService.store(image);
		return "redirect:/";
	}
}
