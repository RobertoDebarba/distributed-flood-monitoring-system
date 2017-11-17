package br.com.robertodebarba.floodmonitoring.core.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Component
interface FloodRepository : MongoRepository<Flood, String>, PagingAndSortingRepository<Flood, String> {

    fun findAllByOrderByDateDesc(pageable: Pageable): Page<Flood>

}