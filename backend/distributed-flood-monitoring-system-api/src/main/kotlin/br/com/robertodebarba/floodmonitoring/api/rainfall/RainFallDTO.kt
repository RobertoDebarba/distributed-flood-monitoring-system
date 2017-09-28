package br.com.robertodebarba.floodmonitoring.api.rainfall

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalDateTime

class RainFallDTO(@JsonDeserialize(using = LocalDateDeserializer::class) val time: LocalDateTime,
                  val intensity: Float,
                  val stationName: String,
                  val city: String,
                  val federationUnit: String)