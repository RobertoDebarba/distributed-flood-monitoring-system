package br.com.robertodebarba.floodmonitoring.core.database

import com.mongodb.MongoClient
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia

object MongoDatabase {

    val instance: Datastore by lazy { Holder.INSTANCE }

    private object Holder {
        val INSTANCE = createInstance()
    }

    private fun createInstance(): Datastore {
        val morphia = Morphia()

        val datastore = morphia.createDatastore(MongoClient(), "floodMonitoring")
        datastore.ensureIndexes()

        return datastore
    }

}
