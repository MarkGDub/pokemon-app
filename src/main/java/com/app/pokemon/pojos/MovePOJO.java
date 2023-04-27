package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon move and is used to help
 * ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class MovePOJO {
	private String name;

	/**
	 * gets name of pokemon move
	 * 
	 * @return pokemon move
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of pokemon move
	 * 
	 * @param name of move
	 */
	public void setName(String name) {
		this.name = name;
	}

}
