package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RainFallRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
class RainFallConsumer : AbstractEntityConsumer<RainFall>("RAINFALL") {

    @Autowired
    private lateinit var repository: RainFallRepository

    override fun getRepository(): MongoRepository<RainFall, String> {
        return repository
    }

}