package com.parser.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.app.pokemon.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.parser.json.pojo.AuthorPOJO;
import com.parser.json.pojo.BookPOJO;
import com.parser.json.pojo.DayPOJO;
import com.parser.json.pojo.SimpleTestCaseJson;

public class JsonTest {
	private String simpleTestCaseJsonSource = "{ \"title\": \"JSON Testing\", \"author\": \"Mike\"  }";
	private String dayScenario1 = "{\n" + " \"date\": \"2023-03-17\",\n" + " \"name\": \"St Patrick's Day\"\n" + "}\n";
	private String authorBookScenario = "{\n" + "    \"authorName\": \"Rui\",\n" + "    \"books\": [\n"
			+ "            {\n" + "                \"title\": \"title1\",\n" + "                \"inPrint\": true,\n"
			+ "                \"publishDate\": \"2019-12-25\"\n" + "            },\n" + "            {\n"
			+ "                \"title\": \"title2\",\n" + "                \"inPrint\": false,\n"
			+ "                \"publishDate\": \"2019-12-25\"\n" + "            }\n" + "    ]\n" + "}\n" + "";

	@Test
	public void testParse() throws IOException {
		JsonNode node = Json.parse(simpleTestCaseJsonSource);

		assertEquals(node.get("title").asText(), "JSON Testing");
	}

	@Test
	public void testFromJson() throws IOException {
		JsonNode node = Json.parse(simpleTestCaseJsonSource);
		SimpleTestCaseJson pojo = Json.fromJson(node, SimpleTestCaseJson.class);

		assertEquals(pojo.getTitle(), "JSON Testing");
	}

	@Test
	public void toJson() {
		SimpleTestCaseJson pojo = new SimpleTestCaseJson();
		pojo.setTitle("Testing 123");

		JsonNode node = Json.toJson(pojo);

		assertEquals(node.get("title").asText(), "Testing 123");
	}

	@Test
	public void stringify() throws JsonProcessingException {
		SimpleTestCaseJson pojo = new SimpleTestCaseJson();
		pojo.setTitle("Testing 123");

		JsonNode node = Json.toJson(pojo);

		String stringifiedObj = Json.stringify(node);

		System.out.println(stringifiedObj);
	}

	@Test
	public void prettyPrint() throws JsonProcessingException {
		SimpleTestCaseJson pojo = new SimpleTestCaseJson();
		pojo.setTitle("Testing 123");

		JsonNode node = Json.toJson(pojo);

		String stringifiedObj = Json.prettyPrint(node);

		System.out.println(stringifiedObj);
	}

	@Test
	public void dayTestScenario1() throws IOException {
		JsonNode node = Json.parse(dayScenario1);

		DayPOJO pojo = Json.fromJson(node, DayPOJO.class);

		assertEquals(pojo.getDate().toString(), "2023-03-17");
	}

	@Test
	public void authorBookScenario1() throws IOException {
		JsonNode node = Json.parse(authorBookScenario);

		AuthorPOJO pojo = Json.fromJson(node, AuthorPOJO.class);

		System.out.println("Author Name: " + pojo.getAuthorName());
		for (BookPOJO book : pojo.getBooks()) {
			System.out.println("Book Title: " + book.getTitle());
			System.out.println("Book In Print: " + book.isInPrint());
			System.out.println("Book Publish Date: " + book.getPublishDate());
		}
	}
}