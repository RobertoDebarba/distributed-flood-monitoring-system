package br.com.robertodebarba.floodmonitoring.core.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*
import javax.annotation.Generated

@Document
@CompoundIndex(name = "river", def = "{'river':1, 'city':1, 'federationUnit':1}")
data class RiverLevel(
        @Generated @Id var id: String = UUID.randomUUID().toString(),
        var time: LocalDateTime = LocalDateTime.now(),
        var level: Float = 0F,
        var river: String = "uninformed",
        var city: String = "uninformed",
        var federationUnit: String = "uninformed"
)
