package com.app.pokemon.pojos;

/**
 * plain old java object that represents an outer pokemon object received in in
 * the response and helps access inner pokemon object
 * 
 * @author Mark GW + John R
 *
 */
public class PokemonWrapperPOJO {
	PokemonPOJO pokemon;

	/**
	 * gets pokemon pojo
	 * 
	 * @return pokemon pojo
	 */
	public PokemonPOJO getPokemon() {
		return pokemon;
	}

	/**
	 * sets pokemon pojo
	 * 
	 * @param pokemon pojo
	 */
	public void setPokemon(PokemonPOJO pokemon) {
		this.pokemon = pokemon;
	}

}
