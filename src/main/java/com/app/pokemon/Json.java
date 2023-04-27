package com.app.pokemon;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Helps manage JSON responses from HTTP requests
 * 
 * @author Mark GW + John R
 *
 */
public class Json {
	private static ObjectMapper objectMapper = getDefaultObjectMapper();

	/**
	 * creates the JSON parser from Jackson with some default features
	 * 
	 * @return object mapper to be used to parse json
	 */
	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		defaultObjectMapper.registerModule(new JavaTimeModule());
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultObjectMapper;
	}

	/**
	 * parses string into JSON object
	 * 
	 * @param src
	 * @return parsed JSON object
	 * @throws IOException
	 */
	public static JsonNode parse(String src) throws IOException {
		return objectMapper.readTree(src);
	}

	/**
	 * maps the parsed JSON objects values to a specified Java POJO
	 * 
	 * @param <A>
	 * @param node
	 * @param clazz
	 * @return specified POJO class
	 * @throws JsonProcessingException
	 */
	public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
		return objectMapper.treeToValue(node, clazz);
	}

	/**
	 * transforms a Java POJO back into parsed JSON object
	 * 
	 * @param a
	 * @return json node
	 */
	public static JsonNode toJson(Object a) {
		return objectMapper.valueToTree(a);
	}

	/**
	 * takes parsed JSON object and converts it back into a unformatted string
	 * 
	 * @param node
	 * @return json string
	 * @throws JsonProcessingException
	 */
	public static String stringify(JsonNode node) throws JsonProcessingException {
		return generateString(node, false);
	}

	/**
	 * takes parsed JSON object and converts it back into a nicely formatted string
	 * 
	 * @param node
	 * @return json string
	 * @throws JsonProcessingException
	 */
	public static String prettyPrint(JsonNode node) throws JsonProcessingException {
		return generateString(node, true);
	}

	/**
	 * takes parsed JSON object and converts it into a string
	 * 
	 * @param node
	 * @param pretty
	 * @return json string
	 * @throws JsonProcessingException
	 */
	public static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
		ObjectWriter objectWriter = objectMapper.writer();
		if (pretty)
			objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		return objectWriter.writeValueAsString(node);
	}
}