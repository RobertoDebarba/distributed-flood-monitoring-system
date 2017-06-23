package br.com.robertodebarba.floodmonitoring.api.dam

import br.com.robertodebarba.floodmonitoring.core.Dam
import br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("dam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class DamApi {

    @GET
    fun getDams(): Response {
        try {
            val dams = MongoDatabase.instance.createQuery(Dam::class.java).asList()
            return Response.ok().entity(dams).build()

        } catch (e: Exception) {
            return Response.serverError().entity(e).build()
        }
    }

}
