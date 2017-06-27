package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.Dam
import br.com.robertodebarba.floodmonitoring.core.FloodGate
import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase
import com.google.gson.Gson
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import java.io.IOException

class FloodGateConsumer {

    private val QUEUE_NAME = "FLOODGATE"

    fun Consume() {
        val channel = AmqpConnection.instance.createChannel()

        channel.queueDeclare(QUEUE_NAME, false, false, false, null)
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C")
        val consumer = object : DefaultConsumer(channel) {
            @Throws(IOException::class)
            override fun handleDelivery(consumerTag: String, envelope: Envelope,
                                        properties: AMQP.BasicProperties, body: ByteArray) {
                try {
                    val floodgate = Gson().fromJson(String(body), FloodGate::class.java)
                    floodgate.dam = getDam(floodgate.dam ?: Dam())
                    //TODO Salvar no Bando de Dados
                    MongoDatabase.instance.save(floodgate)
                    println(" [x] Received '$floodgate'")
                } catch (e: Exception) {
                    println(e)
                }
            }
        }
        channel.basicConsume(QUEUE_NAME, true, consumer)
    }

    fun getDam(dam: Dam): Dam {
        var result = MongoDatabase.instance.createQuery(Dam::class.java)
                .field(Dam::name.name).equal(dam.name)
                .field(Dam::city.name).equal(dam.city)
                .field(Dam::federationUnit.name).equal(dam.federationUnit)
                .asList()
                .firstOrNull()

        if (result == null) {
            MongoDatabase.instance.save(dam)
            return dam
        } else return result
    }
}