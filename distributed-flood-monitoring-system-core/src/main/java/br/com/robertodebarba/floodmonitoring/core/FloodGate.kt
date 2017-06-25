package br.com.robertodebarba.floodmonitoring.core

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id
import org.mongodb.morphia.annotations.Reference

import java.time.ZonedDateTime

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity("floadGates")
class FloodGate {

    @Id
    val id: ObjectId? = null
    private val time: ZonedDateTime? = null
    private val status: Boolean = false
    @Reference
    private val dam: Dam? = null

}
