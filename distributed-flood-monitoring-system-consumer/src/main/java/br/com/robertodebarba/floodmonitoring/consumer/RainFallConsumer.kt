package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.RainFall
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import java.io.IOException

class RainFallConsumer {
    private val QUEUE_NAME = "RAINFALL"

    fun Consume() {
        val factory = ConnectionFactory()
        factory.host = "localhost"
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.queueDeclare(QUEUE_NAME, false, false, false, null)
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C")
        val consumer = object : DefaultConsumer(channel) {
            @Throws(IOException::class)
            override fun handleDelivery(consumerTag: String, envelope: Envelope,
                                        properties: AMQP.BasicProperties, body: ByteArray) {
                val obj = body as RainFall

                //br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase.instance.save(obj)
                println(" [x] Received '$obj'")
            }
        }
        channel.basicConsume(QUEUE_NAME, true, consumer)
    }
}