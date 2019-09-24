package com.sena.apps;
import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;






@Path("/books")
public class BookService {

	static ArrayList<Book> books = new ArrayList<Book>();
	//static {
		//books.add(new Book("Da Vinci", "Dan Brown", 1));
		//books.add(new Book("Da Vinci2", "Dan Brown2", 2));
		
//	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getBooksInJSON() {

		

		return books;

	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookInJSON(@PathParam("id") String id) {
		Book book;
		for(Book b : books) {
			if(b.id==Integer.parseInt(id)) {
				return b;
			}
		}

		throw new IllegalStateException("BAD_REQUEST");
	//	return books.get(Integer.parseInt(id));

	}

	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBookInJSON(Book book) {
		
		for(Book b : books) {
			if(book.getAuthor().equals(b.getAuthor())&& book.getTitle().equals(b.getTitle())) {
				return Response.status(200).entity("You cannot add a book with the same title and author").build();
			}
		}
		

		books.add(book);
		String result = "Books saved : " + book;
		return Response.status(200).entity(result).build();
		
	} 
	
}