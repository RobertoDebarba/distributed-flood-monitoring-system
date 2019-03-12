package br.com.robertodebarba.floodmonitoring.producer

object Producer {

    val RAINFALL = 1
    val RIVERLEVEL = 2
    val FLOOD = 3

    @JvmStatic
    fun main(args: Array<String>) {

        println("1 - Estação de chuva ")
        println("2 - Nivel do rio ")
        println("3 - Enchentes ")
        println("Tipo de Produtor:")

        val tipo = readLine()?.toInt() ?: 1

        if (tipo == RAINFALL) RainFallProducer().produce()
        if (tipo == RIVERLEVEL) RiverLevelProducer().produce()
        if (tipo == FLOOD) FloodProducer().produce()
    }
}
