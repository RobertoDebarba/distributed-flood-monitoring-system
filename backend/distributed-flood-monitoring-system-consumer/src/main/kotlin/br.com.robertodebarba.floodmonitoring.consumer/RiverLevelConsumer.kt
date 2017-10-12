package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName.RIVER_LEVEL
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service


@Service
class RiverLevelConsumer : AbstractEntityConsumer<RiverLevel>(RIVER_LEVEL.name) {

    @Autowired
    private lateinit var repository: RiverLevelRepository

    override fun getRepository(): MongoRepository<RiverLevel, String> {
        return repository
    }

}