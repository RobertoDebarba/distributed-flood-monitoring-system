package br.com.robertodebarba.floodmonitoring.api.riverlevel

import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import org.springframework.stereotype.Component

@Component
class RiverLevelMapper {

    fun toDTO(entity: RiverLevel) =
            RiverLevelDTO(entity.time, entity.level, entity.river, entity.city, entity.federationUnit)

}