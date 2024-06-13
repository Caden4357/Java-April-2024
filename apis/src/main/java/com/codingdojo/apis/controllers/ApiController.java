package com.codingdojo.apis.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.codingdojo.apis.models.Pokemon;
import com.codingdojo.apis.models.PokemonList;

@RestController
public class ApiController {
	private String baseUrl = "https://pokeapi.co/api/v2/";
	
	private WebClient client = WebClient.create();
	
	public PokemonList getFirstTenPoke() {
	PokemonList response = client
			.get()
			.uri(baseUrl + "pokemon")
			.retrieve()
			.bodyToMono(PokemonList.class)
			.block();
		return response;
	}
	
	public Pokemon searchForOnePoke(String searchQuery) {
		Pokemon pokemon = client
				.get()
				.uri(baseUrl + "pokemon/" + searchQuery)
				.retrieve()
				.bodyToMono(Pokemon.class)
				.block();
		return pokemon;
	}
}
