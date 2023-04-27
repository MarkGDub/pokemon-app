package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon type and is used to help
 * ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class TypePOJO {
	private String name;
	private String url;

	/**
	 * gets name of pokemon type
	 * 
	 * @return pokemon type name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of pokemon type
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets pokemon type detail url
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * sets the pokemon type detail url
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
