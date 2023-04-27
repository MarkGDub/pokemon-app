package com.app.pokemon.pojos;

/**
 * plain old java object that contains all the different pokemon types pojos and
 * is used to help ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class AllPokemonTypesPOJO {
	PokemonTypePOJO[] results;

	/**
	 * gets list of pokemon type pojos
	 * 
	 * @return list of pokemon type pojos
	 */
	public PokemonTypePOJO[] getResults() {
		return results;
	}

	/**
	 * sets list of pokemon type pojos
	 * 
	 * @param results which is what json property the pokemon types are in
	 */
	public void setResults(PokemonTypePOJO[] results) {
		this.results = results;
	}

}
