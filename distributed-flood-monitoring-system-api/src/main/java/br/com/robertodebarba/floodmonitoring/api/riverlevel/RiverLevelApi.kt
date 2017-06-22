package br.com.robertodebarba.floodmonitoring.api.riverlevel

import br.com.robertodebarba.floodmonitoring.core.RiverLevel
import br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("riverlevel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class RiverLevelApi {

    @GET
    fun getProducts(): Response {
        try {
            val level = RiverLevel()
            level.river = "Rio dos Cedros"
            level.city = "Timbó"
            level.federationUnit = "SC"
            level.level = 20F

            MongoDatabase.instance.save(level)
            val riverLevels = MongoDatabase.instance.createQuery(RiverLevel::class.java).asList()

            return Response.ok().entity(riverLevels).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e).build()
        }
    }

}
