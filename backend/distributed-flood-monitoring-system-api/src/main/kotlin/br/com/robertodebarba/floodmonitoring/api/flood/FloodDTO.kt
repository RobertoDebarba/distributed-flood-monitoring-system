package br.com.robertodebarba.floodmonitoring.api.flood

import java.time.LocalDateTime

class FloodDTO(var year: Int,
        var date: LocalDateTime,
        var level: Float,
        var city: String ,
        var federationUnit: String )