package br.com.robertodebarba.floodmonitoring.consumer.ceops.model

import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class RiverLevelMapper {

    fun toEntity(ceopsRecord: CeopsRecord): RiverLevel {
        val ceopsDatePatern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

        val time = LocalDateTime.parse(ceopsRecord.data, ceopsDatePatern)
        val level = ceopsRecord.vlr_nivel
        val river = "Itajaí-Açu"
        val city = "Blumenau"
        val federationUnit = "SC"

        return RiverLevel(id = null, time = time, level = level, river = river, city = city, federationUnit = federationUnit)
    }

}