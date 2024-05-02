package com.codingdojo.helloWorld;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}
	@RequestMapping("/hello/{name}/{role}")
	public String greeting(@PathVariable("name") String name, @PathVariable("role") String role) {
		return "Hello " + name + " You signed in as a " ;
	}
}
