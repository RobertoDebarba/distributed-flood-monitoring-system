package br.com.robertodebarba.floodmonitoring.core

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.*

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity("dams")
@Indexes(Index(value = "dam", fields = arrayOf(Field("name"), Field("city"), Field("federationUnit"))))
class Dam {

    @Id
    var id: ObjectId? = null
    var name: String? = null
    var city: String? = null
    var federationUnit: String? = null
    var capacity: Float = 0.toFloat()
    var floodgates: Int = 0

}
