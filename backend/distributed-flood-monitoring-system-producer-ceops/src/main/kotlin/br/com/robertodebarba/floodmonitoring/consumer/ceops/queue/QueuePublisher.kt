package br.com.robertodebarba.floodmonitoring.consumer.ceops.queue

import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName.RAIN_FALL
import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName.RIVER_LEVEL
import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName.FLOOD
import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

class QueuePublisher<in T>(private val queueName: String) {

    private val logger = LoggerFactory.getLogger(this.javaClass)!!

    private val channel = AmqpConnection.instance.createChannel()

    init {
        channel.queueDeclare(queueName, false, false, false, null)
    }

    fun publish(entity: T) {
        channel.basicPublish("", queueName, null, Gson().toJson(entity).toByteArray())
        logger.info("$queueName: published $entity")
    }

}

@Component
class QueuePublisherBean {

    @Bean
    fun riverLevelQueuePublisher() = QueuePublisher<RiverLevel>(RIVER_LEVEL.name)

    @Bean
    fun rainFallQueuePublisher() = QueuePublisher<RainFall>(RAIN_FALL.name)

    @Bean
    fun floodQueuePublisher() = QueuePublisher<Flood>(FLOOD.name)
}

