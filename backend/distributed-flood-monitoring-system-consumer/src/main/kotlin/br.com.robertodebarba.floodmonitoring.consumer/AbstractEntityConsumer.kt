package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import com.google.gson.Gson
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

abstract class AbstractEntityConsumer<T : Any>(val queueName: String) {

    val logger = LoggerFactory.getLogger(this.javaClass)!!

    inline fun <reified R : T> consume() {

        val channel = AmqpConnection.instance.createChannel()
        channel.queueDeclare(queueName, false, false, false, null)

        logger.info("Waiting for messages...")

        val consumer = object : DefaultConsumer(channel) {

            override fun handleDelivery(consumerTag: String,
                                        envelope: Envelope,
                                        properties: AMQP.BasicProperties,
                                        body: ByteArray) {

                getRepository().save(Gson().fromJson(String(body), R::class.java))
                logger.info("Received: ${String(body)}")
            }

        }

        channel.basicConsume(queueName, true, consumer)
    }

    abstract fun getRepository(): MongoRepository<T, String>

}