package bookapp;


import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	//if book store is empty
public void testEmptyBookStore() {
		
		
		

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/bookapp/api/books/get" );

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		
		response.bufferEntity();
		System.out.println(response.getStatus());
		System.out.println(response.getEntity(String.class));
		
		
		   assertEquals(response.getStatus(), 200);
		   assertEquals(response.getEntity(String.class), "no books"); //we are expecting of no books at the begining of book store
		   

		

	  
}
//put book test
public void testPutBookTest() {
	
	
	

	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/input/result");
	String input = "{\"id\":1,\"title\":\"Da Vinci\",\"author\":\"Dan Brown\"}";
	ClientResponse response = webResource
	    .type("application/json")
	    .put(ClientResponse.class, input);
	   

	response.bufferEntity();
	System.out.println(response.getStatus());
	System.out.println(response.getEntity(String.class));
	
	
	  assertEquals(response.getStatus(), 200);
		
	  assertEquals(response.getEntity(String.class), input); //response
	  

	
  
}
//if title is empty
public void testPutEmptyTitleBookTest() {
	
	
	

	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/input/result");
	String input = "{\"id\":1,\"title\":\"\",\"author\":\"Dan Brown\"}";
	ClientResponse response = webResource
	    .type("application/json")
	    .put(ClientResponse.class, input);
	   

	response.bufferEntity();
	System.out.println(response.getStatus());
	System.out.println(response.getEntity(String.class));
	
	
	  assertEquals(response.getStatus(), 400);
		
	  assertEquals(response.getEntity(String.class), "{error: Field 'title' is required}"); 
	  

	
  
}
//if author is empty
public void testPutEmptyAuthorBookTest() {
	
	
	

	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/input/result");
	String input = "{\"id\":1,\"title\":\"\",\"author\":\"\"}";
	ClientResponse response = webResource
	    .type("application/json")
	    .put(ClientResponse.class, input);
	   

	response.bufferEntity();
	System.out.println(response.getStatus());
	System.out.println(response.getEntity(String.class));
	
	
	  assertEquals(response.getStatus(), 400);
	 
	  assertEquals(response.getEntity(String.class), "{error : Field 'author' is required}"); 
	  

	
  
}
	@Test
	public void testGetBooksTest() {
		
	
		

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/bookapp/api/books/get");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			
			   assertEquals(response.getStatus(), 200);
			

			response.bufferEntity();
			System.out.println(response.getEntity(String.class));

		  
	}
	
	public void testGetExistingBookTest() {
		
		
		String id = "1";

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/bookapp/api/books/" + id);

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		
		response.bufferEntity();
		System.out.println(response.getStatus());
		System.out.println(response.getEntity(String.class));
		
		
		   assertNotEquals(response.getStatus(), 404);
		   

		

	  
}
	//if id is not existing...
	public void testGetNotExistingBookTest() {
		
		
		String id = "5";

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/bookapp/api/books/" + id);

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		
		response.bufferEntity();
		System.out.println(response.getStatus());
		System.out.println(response.getEntity(String.class));
		
		//expected 404 not found
		 assertNotEquals(response.getStatus(), 404);
		   

		

	  
}


}
