package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon's stat and is used to help
 * ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class StatPOJO {
	private String name;

	/**
	 * gets name of stat
	 * 
	 * @return stat name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets stat name
	 * 
	 * @param name of stat
	 */
	public void setName(String name) {
		this.name = name;
	}

}
