package br.com.robertodebarba.floodmonitoring.api.dashboard

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalDateTime

class DashboardDTO(val riverLevel: Float,
                   val rainIntensity: RainIntensity,
                   val riverStatus: RiverStatus,
                   val riverLevelHistoric: List<Float>,
                   @JsonDeserialize(using = LocalDateDeserializer::class) val riverLevelHistoricTime: List<LocalDateTime>)