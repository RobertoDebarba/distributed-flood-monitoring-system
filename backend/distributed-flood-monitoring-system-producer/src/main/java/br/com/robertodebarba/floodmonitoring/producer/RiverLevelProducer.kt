package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.RiverLevel
import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import com.google.gson.Gson
import java.util.*

class RiverLevelProducer {

    private val QUEUE_NAME = "RIVERLEVEL"

    fun Produce() {
        val riverLevel = RiverLevel()
        println("Cidade : ")
        riverLevel.city = readLine()
        println("Estado : ")
        riverLevel.federationUnit = readLine()
        println("Rio : ")
        riverLevel.river = readLine()

        val channel = AmqpConnection.instance.createChannel()
        riverLevel.level = 20F

        val rnd = Random()
        while (true) {
            var diference = rnd.nextFloat()
            if (!rnd.nextBoolean()) diference *= -1
            riverLevel.level += diference
            if (riverLevel.level < 0) riverLevel.level = 0F
            riverLevel.time = Date()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(riverLevel).toByteArray())
            println(riverLevel)
            Thread.sleep(5000)
        }
    }
}