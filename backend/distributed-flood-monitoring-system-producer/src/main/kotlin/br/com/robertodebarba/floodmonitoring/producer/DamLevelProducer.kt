//package br.com.robertodebarba.floodmonitoring.producer
//
//import br.com.robertodebarba.floodmonitoring.core.amqp.AmqpConnection
//import br.com.robertodebarba.floodmonitoring.core.entity.Dam
//import br.com.robertodebarba.floodmonitoring.core.entity.DamLevel
//import com.google.gson.Gson
//import java.util.*
//
//class DamLevelProducer {
//
//    private val QUEUE_NAME = "damlevel"
//
//    fun Produce() {
//        val dam = Dam()
//        println("Nome da Barragem : ")
//        dam.name = readLine()
//        println("Nome da Cidade : ")
//        dam.city = readLine()
//        println("Sigla do estado : ")
//        dam.federationUnit = readLine()
//        println("Número de comportas : ")
//        dam.floodgates = readLine()?.toIntOrNull() ?: 0
//        println("Capacidade da Barragem : ")
//        dam.capacity = readLine()?.toFloatOrNull() ?: 0F
//
//        val damLevel = DamLevel()
//        damLevel.dam = dam
//
//        val channel = AmqpConnection.instance.createChannel()
//        damLevel.level = 35F
//        val rnd = Random()
//
//        while (true) {
//            var differenca: Float = rnd.nextInt(5).toFloat()
//            if (!rnd.nextBoolean()) differenca *= -1
//            damLevel.level += differenca
//            if (damLevel.level < 0) damLevel.level = 0F
//            damLevel.time = Date()
//
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
//            channel.basicPublish("", QUEUE_NAME, null, Gson().toJson(damLevel).toByteArray())
//            println(damLevel)
//            Thread.sleep(5000)
//        }
//    }
//}