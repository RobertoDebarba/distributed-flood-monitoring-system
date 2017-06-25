package br.com.robertodebarba.floodmonitoring.core

import br.com.robertodebarba.floodmonitoring.core.Deserializer.ZonedDateTimeAdapter
import com.fasterxml.jackson.annotation.JsonInclude
import com.google.gson.annotations.JsonAdapter
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
    @JsonAdapter(ZonedDateTimeAdapter::class)
    var time: ZonedDateTime? = null
    var intensity: Float = 0.toFloat()

}
