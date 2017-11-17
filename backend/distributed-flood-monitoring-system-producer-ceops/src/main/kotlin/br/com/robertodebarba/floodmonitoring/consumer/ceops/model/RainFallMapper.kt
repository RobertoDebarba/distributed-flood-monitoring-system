package br.com.robertodebarba.floodmonitoring.consumer.ceops.model

import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class RainFallMapper {

    fun toEntity(ceopsRecord: CeopsRecord): RainFall {
        val ceopsDatePatern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

        val intensity = ceopsRecord.vlr_precipitacao
        val time = LocalDateTime.parse(ceopsRecord.data, ceopsDatePatern)
        val stationName = "Centro"
        val city = "Blumenau"
        val federationUnit = "SC"

        return RainFall(id = null, time = time, intensity = intensity, stationName = stationName, city = city, federationUnit = federationUnit)
    }

}