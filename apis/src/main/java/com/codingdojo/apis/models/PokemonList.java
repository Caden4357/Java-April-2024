package com.codingdojo.apis.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonList {
	
	@JsonProperty("results")
	private ArrayList<Pokemon> pokeList;

	
	
	public PokemonList() {
	}

	public ArrayList<Pokemon> getPokeList() {
		return pokeList;
	}

	public void setPokeList(ArrayList<Pokemon> pokeList) {
		this.pokeList = pokeList;
	}
	
	
}
