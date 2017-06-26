package br.com.robertodebarba.floodmonitoring.consumer

import br.com.robertodebarba.floodmonitoring.core.Dam
import br.com.robertodebarba.floodmonitoring.core.DamLevel
import br.com.robertodebarba.floodmonitoring.core.database.MongoDatabase
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
                    val damLevel = Gson().fromJson(String(body), DamLevel::class.java)
                    damLevel.dam = getDam(damLevel.dam ?: Dam())
                    //TODO Salvar no Bando de Dados
                    MongoDatabase.instance.save(damLevel)
                    println(" [x] Received '$damLevel'")
                }catch (e : Exception){
                    println(e)
                }

            }
        }
        channel.basicConsume(QUEUE_NAME, true, consumer)
    }

    fun getDam(dam : Dam) : Dam{
        var result = MongoDatabase.instance.createQuery(Dam::class.java)
                .field(Dam::name.name).equal(dam.name)
                .field(Dam::city.name).equal(dam.city)
                .field(Dam::federationUnit.name).equal(dam.federationUnit)
                .asList()
                .firstOrNull()

        if(result == null) {
            MongoDatabase.instance.save(dam)
            return dam
        }
        else return result
    }
}
