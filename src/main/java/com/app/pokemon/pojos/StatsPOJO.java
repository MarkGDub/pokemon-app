package com.app.pokemon.pojos;

/**
 * plain old java object that represents a outer object of pokemon stat and is
 * used to help ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class StatsPOJO {
	private StatPOJO stat;
	private String base_stat;

	/**
	 * gets stat pojo
	 * 
	 * @return stat pojo
	 */
	public StatPOJO getStat() {
		return stat;
	}

	/**
	 * sets stat pojo
	 * 
	 * @param stat pojo
	 */
	public void setStat(StatPOJO stat) {
		this.stat = stat;
	}

	/**
	 * gets base stat
	 * 
	 * @return base state value
	 */
	public String getBase_stat() {
		return base_stat;
	}

	/**
	 * sets base stat
	 * 
	 * @param base_stat
	 */
	public void setBase_stat(String base_stat) {
		this.base_stat = base_stat;
	}

}
