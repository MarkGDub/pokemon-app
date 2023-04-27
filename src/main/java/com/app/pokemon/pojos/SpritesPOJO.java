package com.app.pokemon.pojos;

/**
 * plain old java object that represents a pokemon images and is used to help
 * ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class SpritesPOJO {
	private String front_default;
	private String back_default;

	/**
	 * gets front image of pokemon
	 * 
	 * @return string image url of front of pokemon
	 */
	public String getFront_default() {
		return front_default;
	}

	/**
	 * sets front image of pokemon
	 * 
	 * @param front_default
	 */
	public void setFront_default(String front_default) {
		this.front_default = front_default;
	}

	/**
	 * gets back image of pokemon
	 * 
	 * @return string image url of back of pokemon
	 */
	public String getBack_default() {
		return back_default;
	}

	/**
	 * sets back image of pokemon
	 * 
	 * @param back_default
	 */
	public void setBack_default(String back_default) {
		this.back_default = back_default;
	}

}
