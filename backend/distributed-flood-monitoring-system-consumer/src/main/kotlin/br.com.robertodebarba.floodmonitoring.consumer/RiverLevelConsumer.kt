package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName.RIVER_LEVEL
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevelRepository
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevelSHA1
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevelSHA1Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service


@Service
class RiverLevelConsumer : AbstractEntityConsumer<RiverLevel, RiverLevelSHA1>(RIVER_LEVEL.name) {

    @Autowired
    private lateinit var repository: RiverLevelRepository

    @Autowired
    private lateinit var hashRepository: RiverLevelSHA1Repository

    override fun getRepository(): MongoRepository<RiverLevel, String> {
        return repository
    }

    override fun getSha1Repository(): MongoRepository<RiverLevelSHA1, String> {
        return hashRepository
    }

}