package com.codingdojo.flashfeed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.flashfeed.models.Comment;
import com.codingdojo.flashfeed.models.LoginUser;
import com.codingdojo.flashfeed.models.Post;
import com.codingdojo.flashfeed.models.User;
import com.codingdojo.flashfeed.services.CommentService;
import com.codingdojo.flashfeed.services.PostService;
import com.codingdojo.flashfeed.services.UploadService;
import com.codingdojo.flashfeed.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	UserService users;
	@Autowired
	UploadService images;
	@Autowired
	PostService posts;
	@Autowired
	CommentService comments;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("newUser", new User());
		return "registration.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		users.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "registration.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = users.login(newLogin, result);
		if(result.hasErrors()) {
			
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	@GetMapping("/dashboard")
	public String homepage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		User user = users.getUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("posts", posts.allPost());
		return "dashboard.jsp";
	}
	
	@PostMapping("/upload")
	public String uploadPhoto(@RequestParam("image") MultipartFile image, @RequestParam("title") String title, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		images.store(image);
		System.out.println("/uploads/" + image.getOriginalFilename());
		Post newPost = new Post(title, "/uploads/" + image.getOriginalFilename());
		newPost.setUser(users.getUserById(userId));
		posts.createPost(newPost);
//		create a new post with the image, user and a title
		return "redirect:/dashboard";
	}
	
	@PostMapping("/comment/post/{postId}")
	public String commentOnPost( @PathVariable("postId") Long postId, @RequestParam("body") String body, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		Post post = posts.onePost(postId);
		User user = users.getUserById(userId);
		Comment newComment = new Comment(body, user, post);
		comments.createComment(newComment);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
//		session.setAttribute("userId", null);
		return "redirect:/";
	}
}
