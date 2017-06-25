package br.com.robertodebarba.floodmonitoring.core

import br.com.robertodebarba.floodmonitoring.core.Deserializer.ZonedDateTimeAdapter
import com.fasterxml.jackson.annotation.JsonInclude
import com.google.gson.annotations.JsonAdapter
import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id
import org.mongodb.morphia.annotations.Reference

import java.time.ZonedDateTime

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity("floadGates")
class FloodGate {

    @Id
    var id: ObjectId? = null
    var name: Int = 0
    @JsonAdapter(ZonedDateTimeAdapter::class)
    var time: ZonedDateTime? = null
    var status: Boolean = false
    @Reference
    var dam: Dam? = null

    override fun toString(): String {
        return "FloodGate(time=$time, status=$status)"
    }


}
