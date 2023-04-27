package com.app.pokemon;

import java.awt.Color;

import edu.princeton.cs.algs4.ST;

/**
 * Contains color for each pokemon type
 * 
 * @author John R + Mark GW
 *
 */
public class PokemonTypeColors {
	private static ST<String, Color> st;
	private static final Color tan = new Color(210, 180, 140);
	private static final Color dark_red = new Color(139, 0, 0);
	private static final Color teal = new Color(51, 205, 189);
	private static final Color purple = new Color(138, 51, 205);
	private static final Color mustard = new Color(205, 195, 51);
	private static final Color dark_yellow = new Color(97, 90, 1);
	private static final Color light_green = new Color(178, 255, 77);
	private static final Color pastel_purple = new Color(153, 102, 204);
	private static final Color ice_blue = new Color(204, 255, 255);
	private static final Color dark_purple = new Color(51, 0, 102);

	/**
	 * Initializes symbol table that links a pokemon type to its color
	 */
	public PokemonTypeColors() {
		st = new ST<String, Color>();

		//
		st.put("normal", tan);
		st.put("fighting", dark_red);
		st.put("flying", teal);
		st.put("poison", purple);
		st.put("ground", mustard);
		st.put("rock", dark_yellow);
		st.put("bug", light_green);
		st.put("ghost", pastel_purple);
		st.put("steel", Color.GRAY);
		st.put("fire", Color.RED);
		st.put("water", Color.BLUE);
		st.put("grass", Color.GREEN);
		st.put("electric", Color.YELLOW);
		st.put("psychic", Color.MAGENTA);
		st.put("ice", ice_blue);
		st.put("dragon", dark_purple);
		st.put("dark", Color.BLACK);
		st.put("fairy", Color.PINK);
		st.put("unknown", Color.WHITE);
		st.put("shadow", Color.DARK_GRAY);
	}

	/**
	 * gets Color for pokemon type
	 * 
	 * @param pokemonType
	 * @return color
	 */
	public Color getPokemonTypeColor(String pokemonType) {
		return st.get(pokemonType);
	}

	/**
	 * checks if pokemon type is in the symbol table
	 * 
	 * @param pokemonType
	 * @return boolean
	 */
	public boolean containsPokemonType(String pokemonType) {
		return st.get(pokemonType) != null;
	}
}
