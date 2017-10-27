package br.com.robertodebarba.floodmonitoring.core.entity

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface FloodRepository  : MongoRepository<Flood, String>, PagingAndSortingRepository<Flood, String> {

    fun findAllByOrderByYearDesc(pageable: Pageable): Page<Flood>

    fun findFirst10ByOrderByYearDesc(): List<Flood>

    fun findFirst1ByYearUnitOrderByYearDesc(year: Int): Flood
}