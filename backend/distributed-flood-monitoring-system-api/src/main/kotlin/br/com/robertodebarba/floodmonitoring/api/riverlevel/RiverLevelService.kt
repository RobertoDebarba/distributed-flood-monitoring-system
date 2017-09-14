package br.com.robertodebarba.floodmonitoring.api.riverlevel

import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RiverLevelService {

    @Autowired
    lateinit var mapper: RiverLevelMapper

    @Autowired
    lateinit var repository: RiverLevelRepository

    fun getRiverLevels(pageable: Pageable) =
            dto {
                repository.findAllByOrderByTimeDesc(pageable)
            }

    fun getRiverLevelsByRiverAndCityAndFederationUnit(river: String, city: String, federationUnit: String, pageable: Pageable) =
            dto {
                repository.findByRiverAndCityAndFederationUnitOrderByTimeDesc(river, city, federationUnit, pageable)
            }

    fun dto(producer: () -> Page<RiverLevel>): Page<RiverLevelDTO> =
            producer().map { mapper.toDTO(it) }

}