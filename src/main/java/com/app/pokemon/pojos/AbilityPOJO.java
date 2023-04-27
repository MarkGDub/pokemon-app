package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon's ability and is used to help
 * ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class AbilityPOJO {
	private String name;

	/**
	 * gets name of ability
	 * 
	 * @return ability name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of ability
	 * 
	 * @param name of ability
	 */
	public void setName(String name) {
		this.name = name;
	}

}
