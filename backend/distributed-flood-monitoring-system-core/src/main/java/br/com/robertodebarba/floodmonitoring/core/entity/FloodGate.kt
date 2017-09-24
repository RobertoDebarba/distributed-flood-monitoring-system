//package br.com.robertodebarba.floodmonitoring.core.entity
//
//import com.fasterxml.jackson.annotation.JsonInclude
//import org.bson.types.ObjectId
//import org.mongodb.morphia.annotations.Entity
//import org.mongodb.morphia.annotations.Id
//import org.mongodb.morphia.annotations.Reference
//import java.util.*
//
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@Entity("floadGates")
//class FloodGate {
//
//    @Id
//    var id: ObjectId? = null
//    var name: Int = 0
//    //@JsonAdapter(ZonedDateTimeAdapter::class)
//    var time: Date? = null
//    var status: Boolean = false
//    @Reference
//    var dam: Dam? = null
//
//    override fun toString(): String {
//        return "FloodGate(time=$time, status=$status)"
//    }
//
//
//}