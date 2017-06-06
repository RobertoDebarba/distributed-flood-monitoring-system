package br.com.robertodebarba.jersey_example_project.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class BaseApi {

	@GET
	public String helloWorld() {
		return "Hello World";
	}

}
