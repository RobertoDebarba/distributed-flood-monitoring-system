package br.com.robertodebarba.floodmonitoring.core.entity

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Component
interface RiverLevelSHA1Repository : MongoRepository<RiverLevelSHA1, String>