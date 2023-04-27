package com.app.pokemon.pojos;

/**
 * plain old java object that represents the wrapper pokemon move pojo and is
 * used to help ingest JSON responses from http requests
 * 
 * @author Mark GW + John R
 *
 */
public class KeyMovesPOJO {
	private MovePOJO move;

	/**
	 * gets pokemon move pojo
	 * 
	 * @return pokemon move pojo that contains details on the move
	 */
	public MovePOJO getMove() {
		return move;
	}

	/**
	 * sets pokemon move pojo
	 * 
	 * @param move
	 */
	public void setMove(MovePOJO move) {
		this.move = move;
	}

}
