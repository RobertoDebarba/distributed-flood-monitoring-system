package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.Dam
import br.com.robertodebarba.floodmonitoring.core.FloodGate
import com.google.gson.Gson
import com.rabbitmq.client.ConnectionFactory
import java.time.ZonedDateTime
import java.util.*

class FloodGateProducer {
    private val QUEUE_NAME = "FLOODGATE"
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

        val flodGate = FloodGate()
        flodGate.dam = dam

        println("Numero da porta : ")
        flodGate.name = readLine()?.toIntOrNull() ?: 0

        val factory = ConnectionFactory()
        factory.setHost("localhost")
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        val rnd = Random()
        while (true){
            flodGate.status = rnd.nextBoolean()
            flodGate.time = Date()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(flodGate).toByteArray())
            println(flodGate)
            Thread.sleep(10000)
        }
    }
}