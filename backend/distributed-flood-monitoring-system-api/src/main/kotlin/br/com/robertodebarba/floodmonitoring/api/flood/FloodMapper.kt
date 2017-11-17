package br.com.robertodebarba.floodmonitoring.api.flood

import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import org.springframework.stereotype.Component

@Component
class FloodMapper {

    fun toDTO(entity: Flood) =
            FloodDTO(entity.date, entity.level, entity.city, entity.federationUnit)

}