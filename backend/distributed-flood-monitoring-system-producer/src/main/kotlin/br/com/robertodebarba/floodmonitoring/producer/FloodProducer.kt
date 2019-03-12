package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName
import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import com.google.gson.Gson
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FloodProducer {

    private val QUEUE_NAME = QueueName.FLOOD.name

    fun produce() {
        val channel = AmqpConnection.instance.createChannel()
        val ceopsDatePatern = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        while (true) {
            println("Cidade : ")
            val city = readLine() ?: "uninformed"
            println("Estado : ")
            val federationUnit = readLine() ?: "uninformed"
            println("Ano : ")
            val year = readLine()?.toInt() ?: 0
            println("Data da Medida : ")
            val date = LocalDate.parse(readLine(), ceopsDatePatern)
            println("Medida atingida : ")
            val level = readLine()?.toFloat() ?: 0F


            val rainFall = Flood(city = city, federationUnit = federationUnit, date = date, level = level)

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(rainFall).toByteArray())
            println(rainFall)
        }
    }
}
