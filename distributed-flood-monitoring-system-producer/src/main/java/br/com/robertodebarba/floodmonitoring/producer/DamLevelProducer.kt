package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.Dam
import br.com.robertodebarba.floodmonitoring.core.DamLevel
import br.com.robertodebarba.floodmonitoring.core.Deserializer.GsonAdapted

import com.rabbitmq.client.ConnectionFactory
import java.time.ZonedDateTime
import java.util.*

class DamLevelProducer {
    private val QUEUE_NAME = "damlevel"
    fun Produce(){
        val dam = Dam()
        println("Nome da Barragem : ")
        dam.name = readLine()
        println("Nome da Cidade : ")
        dam.city = readLine()
        println("Sigla do estado : ")
        dam.federationUnit = readLine()
        println("Número de comportas : ")
        dam.floodgates = readLine()?.toIntOrNull() ?: 0
        println("Capacidade da Barragem : ")
        dam.capacity = readLine()?.toFloatOrNull() ?: 0F

        val damLevel = DamLevel()
        damLevel.dam = dam

        val factory = ConnectionFactory()
        factory.setHost("localhost")
        val connection = factory.newConnection()
        val channel = connection.createChannel()
        damLevel.level = 35F
        val rnd = Random()

        while (true){
            val differenca : Float = rnd.nextInt(5).toFloat()
            damLevel.level += differenca
            damLevel.time = ZonedDateTime.now()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, GsonAdapted.toJson(damLevel).toByteArray())
            println(damLevel)
            Thread.sleep(5000)
        }
    }
}