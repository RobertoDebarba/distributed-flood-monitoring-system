package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import br.com.robertodebarba.floodmonitoring.core.entity.Entity
import com.google.gson.Gson
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.transaction.annotation.Transactional
import java.util.*

abstract class AbstractEntityConsumer<T : Entity, E>(val queueName: String) {

    val logger = LoggerFactory.getLogger(this.javaClass)!!

    inline fun <reified R : T, reified S : E> consume() {

        val channel = AmqpConnection.instance.createChannel()
        channel.queueDeclare(queueName, false, false, false, null)

        logger.info("Waiting for messages...")

        val consumer = object : DefaultConsumer(channel) {

            @Transactional
            override fun handleDelivery(consumerTag: String,
                                        envelope: Envelope,
                                        properties: AMQP.BasicProperties,
                                        body: ByteArray) {

                val receivedData = String(body)
                val receivedDataHash = org.apache.commons.codec.digest.DigestUtils.sha1Hex(receivedData)

                val hash = getSha1Repository().findOne(receivedDataHash)

                if (hash != null) {
                    logger.info("Received but is already present: $receivedData")
                    return
                }

                val entityClass = R::class.java
                val entitySha1Class = S::class.java

                val hashInstance = entitySha1Class.getConstructor(String::class.java).newInstance(receivedDataHash)
                getSha1Repository().insert(hashInstance)

                val instance = Gson().fromJson(receivedData, entityClass)
                if (instance.getRawId() == null) {
                    instance.setRawId(UUID.randomUUID().toString())
                }

                getRepository().save(instance)
                logger.info("Received: $receivedData")
            }

        }

        channel.basicConsume(queueName, true, consumer)
    }

    abstract fun getRepository(): MongoRepository<T, String>

    abstract fun getSha1Repository(): MongoRepository<E, String>

}