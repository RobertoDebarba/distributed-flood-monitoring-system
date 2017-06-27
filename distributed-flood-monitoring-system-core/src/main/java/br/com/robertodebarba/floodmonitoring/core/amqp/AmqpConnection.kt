package br.com.robertodebarba.floodmonitoring.core.amqp

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory


object AmqpConnection {

    val instance: Connection by lazy { Holder.INSTANCE }

    private object Holder {
        val INSTANCE = createInstance()
    }

    private fun createInstance(): Connection {
        val rabbitUri = System.getenv("CLOUDAMQP_URL") ?: "amqp://guest:guest@localhost"

        val factory = ConnectionFactory()
        factory.setUri(rabbitUri)
        factory.requestedHeartbeat = 30
        factory.connectionTimeout = 30000

        return factory.newConnection()
    }
}