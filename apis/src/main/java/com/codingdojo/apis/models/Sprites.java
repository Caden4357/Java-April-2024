package com.codingdojo.apis.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {
	
	@JsonProperty("front_shiny")
	private String frontShiny;

	public Sprites() {
	}

	public String getFrontShiny() {
		return frontShiny;
	}

	public void setFrontShiny(String frontShiny) {
		this.frontShiny = frontShiny;
	}
	
	
	
}
