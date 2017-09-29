package br.com.robertodebarba.floodmonitoring.api.rainfall

import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import org.springframework.stereotype.Component

@Component
class RainFallMapper {

    fun toDTO(entity: RainFall) =
            RainFallDTO(entity.time, entity.intensity, entity.stationName, entity.city, entity.federationUnit)
}