package br.com.robertodebarba.floodmonitoring.core.entity

import org.mongodb.morphia.annotations.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*
import javax.annotation.Generated

@Document
@CompoundIndex(name = "flood", def = "{'year':1, 'level':1}")
data class Flood (
        @Generated @Id var id: String = UUID.randomUUID().toString(),
        var year: Int,
        var date: LocalDateTime,
        var level: Float,
        var city: String = "uninformed",
        var federationUnit: String = "uninformed"
)
