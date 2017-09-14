package br.com.robertodebarba.floodmonitoring.producer

object Producer {
    val DAMLEVEL = 1
    val FLOODGATE = 2
    val RAINFALL = 3
    val RIVERLEVEL = 4
    @JvmStatic fun main(args: Array<String>) {

//        println("1 - Nivel da Barragem ")
//        println("2 - Comporta ")
//        println("3 - Estação de chuva ")
        println("4 - Nivel do rio ")
        println("Tipo de Produtor:")

        val tipo = readLine()?.toInt() ?: 1

//        if(tipo == DAMLEVEL) DamLevelProducer().Produce()
//        if(tipo == FLOODGATE) FloodGateProducer().Produce()
//        if(tipo == RAINFALL) RainFallProducer().Produce()
        if(tipo == RIVERLEVEL) RiverLevelProducer().Produce()
    }
}
