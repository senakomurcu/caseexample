package com.sena.apps;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.TestCase;

public class deneme  {

	public static void main(String[] args) {
		
	
		
		

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/bookapp/api/books/get");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			  // assertEquals(response.getStatus(), 200);
			}

			response.bufferEntity();
			System.out.println(response.getEntity(String.class));

		  
		
	}
	

}