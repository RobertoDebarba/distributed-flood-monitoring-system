//package br.com.robertodebarba.floodmonitoring.api.rainfall
//
//import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
//import br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase
//import org.mongodb.morphia.query.FindOptions
//import javax.ws.rs.*
//import javax.ws.rs.core.MediaType
//import javax.ws.rs.core.Response
//
//@Path("rainfall")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//
//class RainFallApi {
//
//    @GET
//    fun getRainFalls(@QueryParam("stationname") stationName: String?, @QueryParam("city") city: String?, @QueryParam("federationunit") federationUnit: String?): Response {
//        try {
//            val rainFallTime = RainFall::time.name
//            val findOptions = FindOptions().limit(10)
//
//            if (stationName.isNullOrBlank() && city.isNullOrBlank() && federationUnit.isNullOrBlank()){
//                val rainfalls = MongoDatabase.instance.createQuery(RainFall::class.java)
//                        .order("-$rainFallTime")
//                        .asList(findOptions)
//                return Response.ok().entity(rainfalls).build()
//            } else if (!stationName.isNullOrBlank() && !city.isNullOrBlank() && !federationUnit.isNullOrBlank()) {
//                val rainfalls = MongoDatabase.instance.createQuery(RainFall::class.java)
//                        .field(RainFall::stationName.name).equal(stationName)
//                        .field(RainFall::city.name).equal(city)
//                        .field(RainFall::federationUnit.name).equal(federationUnit)
//                        .order("-$rainFallTime")
//                        .asList(findOptions)
//                return Response.ok().entity(rainfalls).build()
//            } else {
//                return Response.status(Response.RiverStatus.BAD_REQUEST).build()
//            }
//
//        } catch (e: Exception) {
//            return Response.serverError().entity(e).build()
//        }
//    }
//
//}