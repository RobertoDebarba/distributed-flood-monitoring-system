package br.com.robertodebarba.floodmonitoring.core.entity

import org.mongodb.morphia.annotations.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class RainFallSHA1(
        @Id var id: String
)