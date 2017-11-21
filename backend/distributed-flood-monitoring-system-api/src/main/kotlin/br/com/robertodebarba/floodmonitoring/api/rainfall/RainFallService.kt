package br.com.robertodebarba.floodmonitoring.api.rainfall

import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RainFallRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RainFallService {

    @Autowired
    lateinit var mapper: RainFallMapper

    @Autowired
    lateinit var repository: RainFallRepository

    fun getRainFalls(pageable: Pageable) =
            dto {
                repository.findAllByOrderByTimeDesc(pageable)
            }

    fun getRainFallByStationNameAndCityAndFederationUnit(stationName: String, city: String, federationUnit: String, pageable: Pageable) =
            dto {
                repository.findByStationNameAndCityAndFederationUnitOrderByTimeDesc(stationName, city, federationUnit, pageable)
            }

    private fun dto(producer: () -> Page<RainFall>): Page<RainFallDTO> =
            producer().map { mapper.toDTO(it) }

}