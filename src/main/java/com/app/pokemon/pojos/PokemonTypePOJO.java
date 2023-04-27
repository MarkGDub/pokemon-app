package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon type and is used to help
 * ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class PokemonTypePOJO {
	String name;
	String url;

	/**
	 * get pokemon type name
	 * 
	 * @return name of pokemon type
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
	 * get pokemon type detail url
	 * 
	 * @return string url of pokemon type details url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * sets pokemon type detail url
	 * 
	 * @param url of pokemon type details
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
