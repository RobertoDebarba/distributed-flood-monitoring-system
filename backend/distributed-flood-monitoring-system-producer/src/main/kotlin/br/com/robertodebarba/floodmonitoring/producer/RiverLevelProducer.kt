package br.com.robertodebarba.floodmonitoring.producer

import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
import br.com.robertodebarba.floodmonitoring.core.amqp.QueueName
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import com.google.gson.Gson
import java.time.LocalDateTime
import java.util.*

class RiverLevelProducer {

    private val QUEUE_NAME = QueueName.RIVER_LEVEL.name

    fun produce() {
        println("Cidade : ")
        val city = readLine() ?: "uninformed"
        println("Estado : ")
        val federationUnit = readLine() ?: "uninformed"
        println("Rio : ")
        val river = readLine() ?: "uninformed"

        val channel = AmqpConnection.instance.createChannel()

        val rnd = Random()
        while (true) {
            val riverLevel = RiverLevel(city = city, federationUnit = federationUnit, river = river)
            riverLevel.level = 20F

            var diference = rnd.nextFloat()
            if (!rnd.nextBoolean()) diference *= -1
            riverLevel.level += diference
            if (riverLevel.level < 0) riverLevel.level = 0F
            riverLevel.time = LocalDateTime.now()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(riverLevel).toByteArray())
            println(riverLevel)
            Thread.sleep(5000)
        }
    }
}
