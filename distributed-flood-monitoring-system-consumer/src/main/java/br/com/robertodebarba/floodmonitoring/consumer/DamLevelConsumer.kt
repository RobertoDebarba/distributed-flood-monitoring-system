package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.DamLevel
import com.google.gson.Gson
import com.rabbitmq.client.ConnectionFactory
import java.io.IOException
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope


class DamLevelConsumer {
    private val QUEUE_NAME = "damlevel"

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

                try {
                    val obj = Gson().fromJson(String(body), DamLevel::class.java)
                    //TODO Salvar no Bando de Dados
                    //br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase.instance.save(obj)
                    println(" [x] Received '$obj'")
                }catch (e : Exception){
                    println(e)
                }

            }
        }
        channel.basicConsume(QUEUE_NAME, true, consumer)
    }

}
