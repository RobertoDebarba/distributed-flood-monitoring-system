package br.com.robertodebarba.floodmonitoring.api.damlevel

import br.com.robertodebarba.floodmonitoring.core.Dam
import br.com.robertodebarba.floodmonitoring.core.DamLevel
import br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("damlevel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

class DamLevelApi {

    @GET
    fun getDamLevels(@QueryParam("name") name: String?, @QueryParam("city") city: String?, @QueryParam("federationunit") federationUnit: String?): Response {
        try {
            if (name.isNullOrBlank() && city.isNullOrBlank() && federationUnit.isNullOrBlank()){
                val damLevels = MongoDatabase.instance.createQuery(DamLevel::class.java).asList()
                return Response.ok().entity(damLevels).build()
            } else if (!name.isNullOrBlank() && !city.isNullOrBlank() && !federationUnit.isNullOrBlank()) {
                val damLevels = MongoDatabase.instance.createQuery(DamLevel::class.java)
                        .field(Dam::name.name).equal(name)
                        .field(Dam::city.name).equal(city)
                        .field(Dam::federationUnit.name).equal(federationUnit)
                        .asList()
                return Response.ok().entity(damLevels).build()
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build()
            }
        } catch (e: Exception) {
            return Response.serverError().entity(e).build()
        }
    }

}
