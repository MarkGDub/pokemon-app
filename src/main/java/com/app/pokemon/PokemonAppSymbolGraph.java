package com.app.pokemon;

import java.io.IOException;

import com.app.pokemon.pojos.PokemonTypeDetailsPOJO;
import com.app.pokemon.pojos.PokemonTypePOJO;
import com.app.pokemon.pojos.PokemonWrapperPOJO;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.ST;

/**
 * Builds symbol graph to be used to discern what the undirected graph vertexes
 * actually represent
 * 
 * @author Mark GW + John R
 *
 */
public class PokemonAppSymbolGraph {
	private ST<String, Integer> pokemonTypeSt; // string -> index
	private ST<String, String> pokemonDetailsUrlSt;
	private String[] keys; // index -> string
	private Graph graph; // the underlying graph

	/**
	 * Initializes a symbol table and graph from data received by the PokeApi
	 * 
	 * @param filename  the name of the file
	 * @param delimiter the delimiter between fields
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public PokemonAppSymbolGraph() throws IOException, InterruptedException {
		PokemonTypePOJO[] pokemonTypes = PokeApiHttpClient.getAllPokemonTypes();

		pokemonTypeSt = new ST<String, Integer>();
		pokemonDetailsUrlSt = new ST<String, String>();

		// First quarter builds part of the symbol table by adding the pokemon types to
		// the st
		for (PokemonTypePOJO pokemonType : pokemonTypes) {
			if (!pokemonTypeSt.contains(pokemonType.getName())) {
				pokemonTypeSt.put(pokemonType.getName(), pokemonTypeSt.size());
			}
		}

		// Second quarter gets the pokemon and builds out the rest of the symbol table
		for (PokemonTypePOJO pokemonType : pokemonTypes) {
			PokemonTypeDetailsPOJO pokemonTypeDetails = PokeApiHttpClient.getPokemonTypeDetails(pokemonType.getUrl());

			for (PokemonWrapperPOJO pokemonWrapper : pokemonTypeDetails.getPokemon()) {
				if (!pokemonTypeSt.contains(pokemonWrapper.getPokemon().getName())) {
					pokemonTypeSt.put(pokemonWrapper.getPokemon().getName(), pokemonTypeSt.size());
					pokemonDetailsUrlSt.put(pokemonWrapper.getPokemon().getName(),
							pokemonWrapper.getPokemon().getUrl());
				}
			}
		}

		// third quarter creates an inverted index to get string keys in an array
		keys = new String[pokemonTypeSt.size()];
		for (String name : pokemonTypeSt.keys()) {
			keys[pokemonTypeSt.get(name)] = name;
		}

		// last quarter builds the graph by using data received back by PokeApi to map
		// the pokemon to its pokemon types
		graph = new Graph(pokemonTypeSt.size());
		for (PokemonTypePOJO pokemonType : pokemonTypes) {
			Integer pokemonTypeIndex = pokemonTypeSt.get(pokemonType.getName());

			PokemonTypeDetailsPOJO pokemonTypeDetails = PokeApiHttpClient.getPokemonTypeDetails(pokemonType.getUrl());

			for (PokemonWrapperPOJO pokemonWrapper : pokemonTypeDetails.getPokemon()) {
				graph.addEdge(pokemonTypeIndex, pokemonTypeSt.get(pokemonWrapper.getPokemon().getName()));
			}
		}

	}

	/**
	 * Does the graph contain the vertex named {@code s}?
	 * 
	 * @param s the name of a vertex
	 * @return {@code true} if {@code s} is the name of a vertex, and {@code false}
	 *         otherwise
	 */
	public boolean contains(String s) {
		return pokemonTypeSt.contains(s);
	}

	/**
	 * Returns the integer associated with the vertex named {@code s}.
	 * 
	 * @param s the name of a vertex
	 * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex
	 *         named {@code s}
	 */
	public int indexOf(String s) {
		return pokemonTypeSt.get(s);
	}

	/**
	 * Returns the url to get details on a specific pokemon
	 * 
	 * @param s the name of the pokemon
	 * @return pokemon detail url string
	 */
	public String getUrl(String s) {
		return pokemonDetailsUrlSt.get(s);
	}

	/**
	 * Returns the name of the vertex associated with the integer {@code v}.
	 * 
	 * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 * @return the name of the vertex associated with the integer {@code v}
	 */
	public String nameOf(int v) {
		validateVertex(v);
		return keys[v];
	}

	/**
	 * Returns the graph associated with the symbol graph. It is the client's
	 * responsibility not to mutate the graph.
	 * 
	 * @return the graph associated with the symbol graph
	 */
	public Graph graph() {
		return graph;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		int V = graph.V();
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}
}
