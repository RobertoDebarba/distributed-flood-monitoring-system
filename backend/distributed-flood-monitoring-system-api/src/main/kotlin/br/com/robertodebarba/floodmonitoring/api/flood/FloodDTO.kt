package br.com.robertodebarba.floodmonitoring.api.flood

import java.time.LocalDate

class FloodDTO(var date: LocalDate,
               var level: Float,
               var city: String,
               var federationUnit: String)