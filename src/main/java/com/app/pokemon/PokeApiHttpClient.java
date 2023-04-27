package com.app.pokemon;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.app.pokemon.pojos.AllPokemonPOJO;
import com.app.pokemon.pojos.AllPokemonTypesPOJO;
import com.app.pokemon.pojos.PokemonDetailPOJO;
import com.app.pokemon.pojos.PokemonPOJO;
import com.app.pokemon.pojos.PokemonTypeDetailsPOJO;
import com.app.pokemon.pojos.PokemonTypePOJO;
import com.fasterxml.jackson.databind.JsonNode;

import edu.princeton.cs.algs4.ST;

/**
 * Requests and caches raw data from PokeAPI
 * 
 * @author Mark GW + John R
 *
 */
public class PokeApiHttpClient {
	private static HttpClient client = HttpClient.newHttpClient();
	private static ST<String, String> cache = new ST<String, String>();

	/**
	 * makes http request to get all pokemon
	 * 
	 * @return all the pokemon in pokemon pojos
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static PokemonPOJO[] getAllPokemon() throws IOException, InterruptedException {
		String url = "https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0";
		if (cache.contains(url)) {
			JsonNode allPokemonNode = Json.parse(cache.get(url));
			AllPokemonPOJO allPokemon = Json.fromJson(allPokemonNode, AllPokemonPOJO.class);
			return allPokemon.getResults();
		}

		URI allPokemonUri = URI.create("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0");
		HttpRequest allPokemonRequest = HttpRequest.newBuilder().GET().uri(allPokemonUri)
				.header("Accept", "application/JSON").build();

		HttpResponse<String> allPokemonResponse = client.send(allPokemonRequest,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		cache.put(url, allPokemonResponse.body());
		JsonNode allPokemonNode = Json.parse(allPokemonResponse.body());
		AllPokemonPOJO allPokemon = Json.fromJson(allPokemonNode, AllPokemonPOJO.class);
		return allPokemon.getResults();
	}

	/**
	 * makes http request to get all the pokemon types
	 * 
	 * @return all the pokemon type pojos
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static PokemonTypePOJO[] getAllPokemonTypes() throws IOException, InterruptedException {
		String url = "https://pokeapi.co/api/v2/type";
		if (cache.contains(url)) {
			JsonNode allPokemonTypesNode = Json.parse(cache.get(url));
			AllPokemonTypesPOJO allPokemonTypes = Json.fromJson(allPokemonTypesNode, AllPokemonTypesPOJO.class);
			return allPokemonTypes.getResults();
		}

		URI allPokemonTypesUri = URI.create("https://pokeapi.co/api/v2/type");
		HttpRequest allPokemonTypesRequest = HttpRequest.newBuilder().GET().uri(allPokemonTypesUri)
				.header("Accept", "application/JSON").build();

		HttpResponse<String> allPokemonTypesResponse = client.send(allPokemonTypesRequest,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		cache.put(url, allPokemonTypesResponse.body());
		JsonNode allPokemonTypesNode = Json.parse(allPokemonTypesResponse.body());
		AllPokemonTypesPOJO allPokemonTypes = Json.fromJson(allPokemonTypesNode, AllPokemonTypesPOJO.class);
		return allPokemonTypes.getResults();
	}

	/**
	 * makes http request to get details on a pokemon type
	 * 
	 * @param url pokemon type detail url
	 * @return pokemon type detail pojo
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static PokemonTypeDetailsPOJO getPokemonTypeDetails(String url) throws IOException, InterruptedException {
		if (cache.contains(url)) {
			JsonNode pokemonTypeDetailNode = Json.parse(cache.get(url));
			PokemonTypeDetailsPOJO pokemonTypeDetail = Json.fromJson(pokemonTypeDetailNode,
					PokemonTypeDetailsPOJO.class);
			return pokemonTypeDetail;
		}

		URI pokemonTypeDetailsUri = URI.create(url);
		HttpRequest pokemonTypeDetailsRequest = HttpRequest.newBuilder().GET().uri(pokemonTypeDetailsUri)
				.header("Accept", "application/JSON").build();

		HttpResponse<String> pokemonTypeDetailsResponse = client.send(pokemonTypeDetailsRequest,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		cache.put(url, pokemonTypeDetailsResponse.body());
		JsonNode pokemonTypeDetailNode = Json.parse(pokemonTypeDetailsResponse.body());
		return Json.fromJson(pokemonTypeDetailNode, PokemonTypeDetailsPOJO.class);
	}

	/**
	 * makes http request to get details on a specific pokemon
	 * 
	 * @param url pokemon detail url
	 * @return pokemon detail pojo
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static PokemonDetailPOJO getPokemonDetails(String url) throws IOException, InterruptedException {
		if (cache.contains(url)) {
			JsonNode pokemonDetailNode = Json.parse(cache.get(url));
			return Json.fromJson(pokemonDetailNode, PokemonDetailPOJO.class);
		}
		URI pokemonUri = URI.create(url);
		HttpRequest pokemonDetailRequest = HttpRequest.newBuilder().GET().uri(pokemonUri)
				.header("Accept", "application/JSON").build();

		HttpResponse<String> pokemonDetailResponse = client.send(pokemonDetailRequest,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		cache.put(url, pokemonDetailResponse.body());
		JsonNode pokemonDetailNode = Json.parse(pokemonDetailResponse.body());
		return Json.fromJson(pokemonDetailNode, PokemonDetailPOJO.class);
	}
}
