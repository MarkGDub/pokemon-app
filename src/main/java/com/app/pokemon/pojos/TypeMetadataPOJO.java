package com.app.pokemon.pojos;

/**
 * plain old java object that is used to ingest JSON response
 * 
 * @author Mark GW + John R
 *
 */
public class TypeMetadataPOJO {
	private TypePOJO type;

	/**
	 * gets pokemon type from what was in the JSON response
	 * 
	 * @return pokemon type
	 */
	public TypePOJO getType() {
		return type;
	}

	/**
	 * sets the type of the pokemon type
	 * 
	 * @param type
	 */
	public void setType(TypePOJO type) {
		this.type = type;
	}

}
