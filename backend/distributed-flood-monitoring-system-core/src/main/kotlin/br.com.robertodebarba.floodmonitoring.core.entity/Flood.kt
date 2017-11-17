package br.com.robertodebarba.floodmonitoring.core.entity

import org.mongodb.morphia.annotations.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*
import javax.annotation.Generated

@Document
@CompoundIndex(name = "flood", def = "{'city':1, 'federationUnit':1}")
data class Flood(
        @Generated @Id var id: String? = UUID.randomUUID().toString(),
        var date: LocalDate,
        var level: Float,
        var city: String = "uninformed",
        var federationUnit: String = "uninformed"
) : Entity {
    override fun getRawId(): String? = id
    override fun setRawId(id: String) {
        this.id = id
    }
}
