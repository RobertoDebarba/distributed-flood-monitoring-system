package br.com.robertodebarba.floodmonitoring.api.flood

import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import br.com.robertodebarba.floodmonitoring.core.entity.FloodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FloodService {

    @Autowired
    lateinit var mapper: FloodMapper

    @Autowired
    lateinit var repository: FloodRepository

    fun getFloods(pageable: Pageable) =
            dto {
                repository.findAllByOrderByDateDesc(pageable)
            }

    private fun dto(producer: () -> Page<Flood>): Page<FloodDTO> =
            producer().map { mapper.toDTO(it) }

}