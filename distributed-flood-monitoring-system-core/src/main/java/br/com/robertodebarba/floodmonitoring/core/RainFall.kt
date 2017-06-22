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
    private val id: ObjectId? = null
    private val city: String? = null
    private val federationUnit: String? = null
    private val stationName: String? = null
    private val time: ZonedDateTime? = null
    private val intensity: Float = 0.toFloat()

}
