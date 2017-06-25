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
    var id: ObjectId? = null
    var city: String? = null
    var federationUnit: String? = null
    var stationName: String? = null
    var time: ZonedDateTime? = null
    var intensity: Float = 0.toFloat()

}
