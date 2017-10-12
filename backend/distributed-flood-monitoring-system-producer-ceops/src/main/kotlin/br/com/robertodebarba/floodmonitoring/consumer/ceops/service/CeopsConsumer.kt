package br.com.robertodebarba.floodmonitoring.consumer.ceops.service

import br.com.robertodebarba.floodmonitoring.consumer.ceops.service.CeopsApi.BLUMENAU
import br.com.robertodebarba.floodmonitoring.consumer.ceops.model.CeopsRecord
import br.com.robertodebarba.floodmonitoring.consumer.ceops.model.RainFallMapper
import br.com.robertodebarba.floodmonitoring.consumer.ceops.model.RiverLevelMapper
import br.com.robertodebarba.floodmonitoring.consumer.ceops.queue.QueuePublisher
import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import com.github.kittinunf.fuel.httpGet
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class CeopsConsumer {

    private val logger = LoggerFactory.getLogger(this.javaClass)!!

    @Autowired
    private lateinit var riverLevelPublisher: QueuePublisher<RiverLevel>

    @Autowired
    private lateinit var rainFallPublisher: QueuePublisher<RainFall>

    @Autowired
    private lateinit var riverLevelMapper: RiverLevelMapper

    @Autowired
    private lateinit var rainFallMapper: RainFallMapper

    @Scheduled(fixedDelayString = "\${delay}")
    fun consume() {

        BLUMENAU.url.httpGet().responseObject(CeopsRecord.Deserializer()) { _, _, result ->

            val (ceopsRecords, error) = result

            if (error != null) {
                logger.error(error.message, error)
                throw error
            }

            logger.info("Request ${BLUMENAU.url}: 200 OK")

            TODO("filtrar dados já inseridos")

            ceopsRecords?.
                    map { riverLevelMapper.toEntity(it) }?.
                    forEach { riverLevelPublisher.publish(it) }
            ceopsRecords?.
                    map { rainFallMapper.toEntity(it) }?.
                    forEach { rainFallPublisher.publish(it) }

        }

    }

}
