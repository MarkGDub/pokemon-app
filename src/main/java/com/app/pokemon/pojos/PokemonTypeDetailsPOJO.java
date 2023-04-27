package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon type details and is used to
 * help ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class PokemonTypeDetailsPOJO {
	PokemonWrapperPOJO[] pokemon;
	String name;

	/**
	 * gets outer pokemon objects for pokemon types
	 * 
	 * @return outer pokemon pojo
	 */
	public PokemonWrapperPOJO[] getPokemon() {
		return pokemon;
	}

	/**
	 * sets outer pokemon array for pokemon type
	 * 
	 * @param pokemon
	 */
	public void setPokemon(PokemonWrapperPOJO[] pokemon) {
		this.pokemon = pokemon;
	}

	/**
	 * 
	 * @return get pokemon type name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets pokemon type name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
