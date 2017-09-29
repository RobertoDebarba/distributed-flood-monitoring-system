package br.com.robertodebarba.floodmonitoring.core.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Component
interface RiverLevelRepository : MongoRepository<RiverLevel, String>, PagingAndSortingRepository<RiverLevel, String> {

    fun findAllByOrderByTimeDesc(pageable: Pageable): Page<RiverLevel>

    fun findFirst10ByOrderByTimeDesc(): List<RiverLevel>

    fun findByRiverAndCityAndFederationUnitOrderByTimeDesc(river: String, city: String, federationUnit: String, pageable: Pageable): Page<RiverLevel>

    fun findFirst1ByOrderByTimeDesc(): RiverLevel
}