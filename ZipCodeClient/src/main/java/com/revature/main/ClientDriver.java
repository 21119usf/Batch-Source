package com.revature.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.model.ZipCode;

public class ClientDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ZipCodeRestService/rest/zipcodes");
		//Get Request
		Builder getZipCodeBuilder = webTarget.path("33579").request();
		Response getZipCodeResponse = getZipCodeBuilder.accept(MediaType.APPLICATION_JSON).get();
		int statusCode = getZipCodeResponse.getStatus();
		System.out.println("Returned with status code: " + statusCode);
		ZipCode z = getZipCodeResponse.readEntity(ZipCode.class);
		System.out.println(z);
		System.out.println();
		
		//Post Request
		Builder postZipCodeBuilder = webTarget.request();
		z = new ZipCode(28532, "Cherry Point", "North Carolina");
		Response postZipCodeResponse = postZipCodeBuilder.accept(MediaType.APPLICATION_JSON).post(Entity.entity(z, MediaType.APPLICATION_JSON));
		statusCode = getZipCodeResponse.getStatus();
		System.out.println("Returned with status code: " + statusCode);
		

	}

}
