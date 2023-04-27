package com.app.pokemon.pojos;

/**
 * plain old java object that represents the wrapper of a pokemon's ability and
 * is used to help ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class KeyAbilitiesPOJO {
	private AbilityPOJO ability;

	/**
	 * gets pokemon ability pojo
	 * 
	 * @return ability pojo for pokemon
	 */
	public AbilityPOJO getAbility() {
		return ability;
	}

	/**
	 * sets ability of pokemon pojo
	 * 
	 * @param ability
	 */
	public void setAbility(AbilityPOJO ability) {
		this.ability = ability;
	}

}
