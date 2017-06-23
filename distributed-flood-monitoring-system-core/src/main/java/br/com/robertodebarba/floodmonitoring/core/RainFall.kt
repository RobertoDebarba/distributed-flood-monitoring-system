package br.com.robertodebarba.floodmonitoring.core

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.*

import java.time.ZonedDateTime

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity("rainfalls")
@Indexes(Index(value = "rainfall", fields = arrayOf(Field("stationName"), Field("city"), Field("federationUnit"))))
class RainFall {

    @Id
    val id: ObjectId? = null
    val city: String? = null
    val federationUnit: String? = null
    val stationName: String? = null
    val time: ZonedDateTime? = null
    val intensity: Float = 0.toFloat()

}
