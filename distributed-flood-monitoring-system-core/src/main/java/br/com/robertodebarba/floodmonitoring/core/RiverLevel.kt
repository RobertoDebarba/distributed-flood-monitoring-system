package br.com.robertodebarba.floodmonitoring.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.*
import java.util.*

@JsonInclude(Include.NON_DEFAULT)
@Entity("riverLevels")
@Indexes(Index(value = "level", fields = arrayOf(Field("river"), Field("city"), Field("federationUnit"))))
class RiverLevel {

    @Id
    var id: ObjectId? = null
    var level: Float = 0.toFloat()
    //@JsonAdapter(ZonedDateTimeAdapter::class)
    var time: Date? = null
    var river: String? = null
    var city: String? = null
    var federationUnit: String? = null

}
