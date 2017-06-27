package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.RainFall
import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import com.google.gson.Gson
import java.util.*

class RainFallProducer {

    private val QUEUE_NAME = "RAINFALL"

    fun Produce() {
        val rainFall = RainFall()
        println("Cidade : ")
        rainFall.city = readLine()
        println("Estado : ")
        rainFall.federationUnit = readLine()
        println("Estação : ")
        rainFall.stationName = readLine()

        val channel = AmqpConnection.instance.createChannel()
        rainFall.intensity = 20F

        val rnd = Random()
        while (true) {
            var diference = rnd.nextFloat()
            if (!rnd.nextBoolean()) diference *= -1
            rainFall.intensity += diference
            if (rainFall.intensity < 0) rainFall.intensity = 0F
            rainFall.time = Date()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(rainFall).toByteArray())
            println(rainFall)
            Thread.sleep(5000)
        }
    }
}