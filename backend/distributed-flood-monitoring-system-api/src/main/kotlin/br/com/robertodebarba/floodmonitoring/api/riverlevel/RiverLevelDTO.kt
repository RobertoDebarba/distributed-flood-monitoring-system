package br.com.robertodebarba.floodmonitoring.api.riverlevel

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalDateTime

class RiverLevelDTO(@JsonDeserialize(using = LocalDateDeserializer::class) val time: LocalDateTime,
                    val level: Float,
                    val river: String,
                    val city: String,
                    val federationUnit: String)