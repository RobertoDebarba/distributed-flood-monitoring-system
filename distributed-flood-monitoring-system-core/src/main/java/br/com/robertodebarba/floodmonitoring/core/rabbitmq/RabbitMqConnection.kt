package br.com.robertodebarba.floodmonitoring.core.rabbitmq

import com.rabbitmq.client.Channel
import com.rabbitmq.client.ConnectionFactory

object RabbitMqConnection {

    val instance: Channel by lazy { Holder.INSTANCE }

    private object Holder {
        val INSTANCE = createInstance()
    }

    private fun createInstance(): Channel {
        val factory = ConnectionFactory()
        factory.host = System.getenv("RABBITMQ_BIGWIG_URL")
        val connection = factory.newConnection()
        val channel = connection.createChannel()
        return channel
    }
}