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
@Entity("damLevels")
class DamLevel {

    @Id
    var id: ObjectId? = null
    @JsonAdapter(ZonedDateTimeAdapter::class)
    var time: ZonedDateTime? = null
    var level: Float = 0.toFloat()
    @Reference
    var dam: Dam? = null

    override fun toString(): String {
        return "DamLevel(time=$time, level=$level)"
    }


}
