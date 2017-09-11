package br.com.robertodebarba.floodmonitoring.core

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity("rainfalls")
@Indexes(Index(value = "rainfall", fields = arrayOf(Field("stationName"), Field("city"), Field("federationUnit"))))
class RainFall {

    @Id
    var id: ObjectId? = null
    var city: String? = null
    var federationUnit: String? = null
    var stationName: String? = null
    //@JsonAdapter(ZonedDateTimeAdapter::class)
    var time: Date? = null
    var intensity: Float = 0.toFloat()

}
