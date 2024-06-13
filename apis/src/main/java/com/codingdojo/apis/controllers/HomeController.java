package com.codingdojo.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.apis.models.Pokemon;
import com.codingdojo.apis.models.PokemonList;


@Controller
public class HomeController {
	
	@Autowired
	private ApiController api;
	
	@GetMapping("/")
	public String getTenPoke(Model model) {
		PokemonList pokeList = api.getFirstTenPoke();
//		for(Pokemon pokemon : pokeList.getPokeList()) {
//			System.out.println(pokemon.getName());
//		}
		model.addAttribute("pokeList", pokeList.getPokeList());
		return "index.jsp";
	}
	
	@GetMapping("/poke/search")
	public String searchPokemon(@RequestParam("search") String search, Model model) {
		Pokemon p = api.searchForOnePoke(search);
		
		model.addAttribute("pokemon", p);
		
		return "index.jsp";
	}
}
