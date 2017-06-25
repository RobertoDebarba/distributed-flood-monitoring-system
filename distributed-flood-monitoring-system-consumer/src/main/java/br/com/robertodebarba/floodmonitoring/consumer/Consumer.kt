package br.com.robertodebarba.floodmonitoring.consumer

object Consumer{

    val DAMLEVEL = 1
    val FLOODGATE = 2
    val RAINFALL = 3
    val RIVERLEVEL = 4
    @JvmStatic fun main(args: Array<String>) {

        println("1 - Nivel da Barragem ")
        println("2 - Comporta ")
        println("3 - Estação de chuva ")
        println("4 - Nivel do rio ")
        println("Tipo de Consumidor:")
        val tipo = readLine()?.toInt() ?: 1

        if(tipo == DAMLEVEL) DamLevelConsumer().Consume()
        if(tipo == FLOODGATE) FloodGateConsumer().Consume()
        if(tipo == RAINFALL) RainFallConsumer().Consume()
        if(tipo == RIVERLEVEL) RiverLevelConsumer().Consume()
    }
}