package com.app.pokemon.pojos;

/**
 * plain old java object of details on a specific pokemon
 * 
 * @author Mark GW + John R
 *
 */
public class PokemonDetailPOJO {
	private String name;
	private int weight;
	private int height;
	private TypeMetadataPOJO[] types;
	private SpritesPOJO sprites;
	private StatsPOJO[] stats;
	private KeyAbilitiesPOJO[] abilities;
	private KeyMovesPOJO[] moves;

	/**
	 * gets name of pokemon
	 * 
	 * @return pokemon name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of pokemon
	 * 
	 * @param name of pokemon
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets weight of pokemon
	 * 
	 * @return pokemon weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * sets pokemon weight
	 * 
	 * @param weight of pokemon
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * gets height of pokemon
	 * 
	 * @return height of pokemon
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * sets height of pokemon
	 * 
	 * @param height of pokemon
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * gets pokemon type wrapper pojo
	 * 
	 * @return pokemon type wrapper pojo
	 */
	public TypeMetadataPOJO[] getTypes() {
		return types;
	}

	/**
	 * sets pokemon type wrapper pojo
	 * 
	 * @param wrapper type pojo of pokemon type
	 */
	public void setTypes(TypeMetadataPOJO[] types) {
		this.types = types;
	}

	/**
	 * gets sprite pojo that contains the images
	 * 
	 * @return sprite pojo
	 */
	public SpritesPOJO getSprites() {
		return sprites;
	}

	/**
	 * sets sprite pojo
	 * 
	 * @param sprites
	 */
	public void setSprites(SpritesPOJO sprites) {
		this.sprites = sprites;
	}

	/**
	 * gets stats pojo
	 * 
	 * @return stats pojo
	 */
	public StatsPOJO[] getStats() {
		return stats;
	}

	/**
	 * sets stats pojo
	 * 
	 * @param stats
	 */
	public void setStats(StatsPOJO[] stats) {
		this.stats = stats;
	}

	/**
	 * gets key abilities pojo for the pokemon
	 * 
	 * @return
	 */
	public KeyAbilitiesPOJO[] getAbilities() {
		return abilities;
	}

	/**
	 * sets key abilities for a pokemon
	 * 
	 * @param abilities
	 */
	public void setAbilities(KeyAbilitiesPOJO[] abilities) {
		this.abilities = abilities;
	}

	/**
	 * gets pokemon moves pojo list
	 * 
	 * @return
	 */
	public KeyMovesPOJO[] getMoves() {
		return moves;
	}

	/**
	 * sets pokemon moves pojolist
	 * 
	 * @param moves
	 */
	public void setMoves(KeyMovesPOJO[] moves) {
		this.moves = moves;
	}

}
