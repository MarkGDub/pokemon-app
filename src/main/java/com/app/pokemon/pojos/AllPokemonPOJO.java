package com.app.pokemon.pojos;

/**
 * plain old java object used for JSON ingress
 * 
 * @author Mark GW + John R
 *
 */
public class AllPokemonPOJO {
	private int count;
	private PokemonPOJO[] results;

	/**
	 * gets the count of the all pokemon
	 * 
	 * @return number of how many pokemon there are
	 */
	public int getCount() {
		return count;
	}

	/**
	 * sets the count of all the possible pokemon
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * gets array that contains pokemon JSON objects
	 * 
	 * @return
	 */
	public PokemonPOJO[] getResults() {
		return results;
	}

	/**
	 * sets array of all the pokemon JSON objects
	 * 
	 * @param results
	 */
	public void setResults(PokemonPOJO[] results) {
		this.results = results;
	}
}
