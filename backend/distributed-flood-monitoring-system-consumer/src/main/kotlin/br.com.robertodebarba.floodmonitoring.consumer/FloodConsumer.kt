package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName
import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import br.com.robertodebarba.floodmonitoring.core.entity.FloodRepository
import br.com.robertodebarba.floodmonitoring.core.entity.FloodSHA1
import br.com.robertodebarba.floodmonitoring.core.entity.FloodSHA1Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
class FloodConsumer : AbstractEntityConsumer<Flood, FloodSHA1>(QueueName.FLOOD.name) {

    @Autowired
    private lateinit var repository: FloodRepository

    @Autowired
    private lateinit var hashRepository: FloodSHA1Repository

    override fun getRepository(): MongoRepository<Flood, String> {
        return repository
    }

    override fun getSha1Repository(): MongoRepository<FloodSHA1, String> {
        return hashRepository
    }

}