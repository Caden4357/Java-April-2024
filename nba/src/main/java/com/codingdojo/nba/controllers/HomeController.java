package com.codingdojo.nba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.nba.models.Player;
import com.codingdojo.nba.models.Team;
import com.codingdojo.nba.services.PlayerService;
import com.codingdojo.nba.services.TeamService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	TeamService teams;
	@Autowired
	PlayerService players;
	
	@GetMapping("/")
	public String index(@ModelAttribute("team") Team team, Model model) {
		model.addAttribute("teams", teams.findAllTeams());
		return "index.jsp";
	}
//	Post route for new team
	@PostMapping("/newTeam")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("teams", teams.findAllTeams());
			return "index.jsp";
		}else {
			teams.create(team);
			return "redirect:/";
		}
	}
	
	@GetMapping("/addPlayer")
	public String addPlayer(@ModelAttribute("player") Player player, Model model) {
		model.addAttribute("teams", teams.findAllTeams());
		return "playerForm.jsp";
	}
	
	@PostMapping("/newPlayer")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("teams", teams.findAllTeams());
			return "index.jsp";
		}else {
			players.create(player);
			return "redirect:/";
		}
	}
	
	@GetMapping("/team/{id}")
	public String viewOneTeam(@PathVariable("id") Long id, Model model) {
		model.addAttribute("team", teams.getTeamById(id));
		return "team.jsp";
	}
	
	
	
	
}
