package com.parser.json.pojo;

public class AuthorPOJO {
	private String authorName;
	private BookPOJO[] books;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public BookPOJO[] getBooks() {
		return books;
	}

	public void setBooks(BookPOJO[] books) {
		this.books = books;
	}

}
