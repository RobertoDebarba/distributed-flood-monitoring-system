package br.com.robertodebarba.floodmonitoring.core.amqp

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import org.springframework.beans.factory.annotation.Value


object AmqpConnection {

    val instance: Connection by lazy { Holder.INSTANCE }

    private object Holder {
        val INSTANCE = createInstance()
    }

    @Value("\${rabbitmq.uri}")
    private lateinit var uri: String

    private fun createInstance(): Connection {
        val factory = ConnectionFactory()
        factory.setUri(uri)
        factory.requestedHeartbeat = 30
        factory.connectionTimeout = 30000

        return factory.newConnection()
    }
}