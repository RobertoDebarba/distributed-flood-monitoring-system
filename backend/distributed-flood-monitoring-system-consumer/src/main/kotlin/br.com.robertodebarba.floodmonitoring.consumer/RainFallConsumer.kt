package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName.RAIN_FALL
import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RainFallRepository
import br.com.robertodebarba.floodmonitoring.core.entity.RainFallSHA1
import br.com.robertodebarba.floodmonitoring.core.entity.RainFallSHA1Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
class RainFallConsumer : AbstractEntityConsumer<RainFall, RainFallSHA1>(RAIN_FALL.name) {

    @Autowired
    private lateinit var repository: RainFallRepository

    @Autowired
    private lateinit var hashRepository: RainFallSHA1Repository

    override fun getRepository(): MongoRepository<RainFall, String> {
        return repository
    }

    override fun getSha1Repository(): MongoRepository<RainFallSHA1, String> {
        return hashRepository
    }

}