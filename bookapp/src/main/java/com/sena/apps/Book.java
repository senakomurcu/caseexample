package com.sena.apps;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
@JsonPropertyOrder({"title", "author", "id"})
public class Book {

	String title;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title,  String author, int id) {
		super();
		this.title = title;
		this.author = author;
		this.id = id;
	}
	String author;
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", id=" + id + "]";
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

	

	
}