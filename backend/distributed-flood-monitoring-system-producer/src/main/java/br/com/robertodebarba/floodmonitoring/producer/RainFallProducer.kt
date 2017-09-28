package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import com.google.gson.Gson
import java.time.LocalDateTime
import java.util.*

class RainFallProducer {

    private val QUEUE_NAME = "RAINFALL"

    fun Produce() {
        println("Cidade : ")
        val city = readLine() ?: "uninformed"
        println("Estado : ")
        val federationUnit = readLine() ?: "uninformed"
        println("Estação : ")
        val stationName = readLine() ?: "uninformed"

        val channel = AmqpConnection.instance.createChannel()

        val rnd = Random()
        while (true) {
            val rainFall = RainFall(stationName = stationName, city = city, federationUnit = federationUnit)
            rainFall.intensity = 20F

            var diference = rnd.nextFloat()
            if (!rnd.nextBoolean()) diference *= -1
            rainFall.intensity += diference
            if (rainFall.intensity < 0) rainFall.intensity = 0F
            rainFall.time = LocalDateTime.now()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(rainFall).toByteArray())
            println(rainFall)
            Thread.sleep(5000)
        }
    }
}