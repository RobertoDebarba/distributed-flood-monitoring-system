package br.com.robertodebarba.floodmonitoring.core.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Component
interface RainFallRepository : MongoRepository<RainFall, String>, PagingAndSortingRepository<RainFall, String> {

    fun findAllByOrderByTimeDesc(pageable: Pageable): Page<RainFall>

    fun findByStationNameAndCityAndFederationUnitOrderByTimeDesc(stationName: String, city: String, federationUnit: String, pageable: Pageable): Page<RainFall>

}