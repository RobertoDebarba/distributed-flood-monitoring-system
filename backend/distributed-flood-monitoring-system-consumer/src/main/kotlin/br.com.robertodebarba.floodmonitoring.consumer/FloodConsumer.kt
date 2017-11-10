package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName
import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import br.com.robertodebarba.floodmonitoring.core.entity.FloodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
class FloodConsumer: AbstractEntityConsumer<Flood>(QueueName.FLOOD.name) {

    @Autowired
    private lateinit var repository: FloodRepository

    override fun getRepository(): MongoRepository<Flood, String> {
        return repository
    }

}