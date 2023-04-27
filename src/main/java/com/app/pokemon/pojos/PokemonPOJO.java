package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon and has basic info
 * 
 * @author Mark GW + John R
 *
 */
public class PokemonPOJO {
	private String name;
	private String url;

	/**
	 * gets name of the pokemon
	 * 
	 * @return pokemon name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the pokemon
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the url string to get more details on the pokemon
	 * 
	 * @return pokemon detail url string
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * sets the pokemon detail url string
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
