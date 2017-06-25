package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.RainFall
import com.google.gson.Gson
import com.rabbitmq.client.ConnectionFactory
import java.time.ZonedDateTime
import java.util.*

class RainFallProducer {
    private val QUEUE_NAME = "RAINFALL"
    fun Produce(){
        val rainFall = RainFall()
        println("Cidade : ")
        rainFall.city = readLine()
        println("Estado : ")
        rainFall.federationUnit = readLine()
        println("Estação : ")
        rainFall.stationName = readLine()

        val factory = ConnectionFactory()
        factory.setHost("localhost")
        val connection = factory.newConnection()
        val channel = connection.createChannel()
        rainFall.intensity = 20F

        val rnd = Random()
        while (true){
            var diference = rnd.nextFloat()
            if(!rnd.nextBoolean()) diference = diference * -1
            rainFall.intensity += diference
            if(rainFall.intensity < 0) rainFall.intensity = 0F
            rainFall.time = ZonedDateTime.now()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(rainFall).toByteArray())
            println(rainFall)
            Thread.sleep(5000)
        }
    }
}