package br.com.robertodebarba.floodmonitoring.api.flood

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class FloodApi {

    @Autowired
    lateinit var service: FloodService

    @CrossOrigin
    @RequestMapping("flood")
    fun getRiverLevels(pageable: Pageable): Page<FloodDTO> {

        return service.getFloods(pageable)

    }

}

