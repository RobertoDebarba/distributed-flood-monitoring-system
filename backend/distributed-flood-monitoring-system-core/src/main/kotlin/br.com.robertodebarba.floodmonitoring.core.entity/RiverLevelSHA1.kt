package br.com.robertodebarba.floodmonitoring.core.entity

import org.mongodb.morphia.annotations.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class RiverLevelSHA1(
        @Id var id: String
)