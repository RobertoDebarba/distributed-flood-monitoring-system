package br.com.robertodebarba.floodmonitoring.core.entity

import org.mongodb.morphia.annotations.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*
import javax.annotation.Generated

@Document
@CompoundIndex(name = "rainfall", def = "{'stationName':1, 'city':1, 'federationUnit':1}")
data class RainFall(
        @Generated @Id var id: String = UUID.randomUUID().toString(),
        var intensity: Float = 0.toFloat(),
        var time: LocalDateTime = LocalDateTime.now(),
        var stationName: String = "uninformed",
        var city: String = "uninformed",
        var federationUnit: String = "uninformed"
)
