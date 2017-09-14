//package br.com.robertodebarba.floodmonitoring.core.database
//
//import com.mongodb.MongoClient
//import com.mongodb.MongoClientURI
//import org.mongodb.morphia.Datastore
//import org.mongodb.morphia.Morphia
//
//object MongoDatabase {
//
//    val instance: Datastore by lazy { Holder.INSTANCE }
//
//    private object Holder {
//        val INSTANCE = createInstance()
//    }
//
//    private fun createInstance(): Datastore {
//        val mongoDbUri = System.getenv("MONGODB_URI") ?: "mongodb://localhost/floodMonitoring"
//        val mongoDbName = System.getenv("MONGODB_NAME") ?: "floodMonitoring"
//
//        val morphia = Morphia()
//
//        val datastore = morphia.createDatastore(MongoClient(MongoClientURI(mongoDbUri)), mongoDbName)
//        datastore.ensureIndexes()
//
//        return datastore
//    }
//
//}
