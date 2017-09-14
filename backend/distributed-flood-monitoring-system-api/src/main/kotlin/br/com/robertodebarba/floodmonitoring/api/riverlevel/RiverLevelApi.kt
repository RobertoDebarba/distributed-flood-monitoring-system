package br.com.robertodebarba.floodmonitoring.api.riverlevel

import br.com.robertodebarba.floodmonitoring.api.IllegalApiArgumentException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class RiverLevelApi {

    @Autowired
    lateinit var service: RiverLevelService

    @RequestMapping("riverlevel")
    fun getRiverLevels(@RequestParam(required = false) river: String?,
                       @RequestParam(required = false) city: String?,
                       @RequestParam(required = false) federationUnit: String?,
                       pageable: Pageable): Page<RiverLevelDTO> {

        return if (river.isNullOrBlank() && city.isNullOrBlank() && federationUnit.isNullOrBlank()) {
            service.getRiverLevels(pageable)

        } else if (!river.isNullOrBlank() && !city.isNullOrBlank() && !federationUnit.isNullOrBlank()) {
            service.getRiverLevelsByRiverAndCityAndFederationUnit(river!!, city!!, federationUnit!!, pageable)

        } else {
            throw IllegalApiArgumentException("river, city and/or federationUnit not informed")
        }

    }

}

