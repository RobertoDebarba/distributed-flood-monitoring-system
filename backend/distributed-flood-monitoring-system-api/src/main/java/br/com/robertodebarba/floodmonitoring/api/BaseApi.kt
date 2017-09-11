package br.com.robertodebarba.floodmonitoring.api

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
class BaseApi {

    @GET
    fun helloWorld(): String {
        return "Hello World"
    }

}
