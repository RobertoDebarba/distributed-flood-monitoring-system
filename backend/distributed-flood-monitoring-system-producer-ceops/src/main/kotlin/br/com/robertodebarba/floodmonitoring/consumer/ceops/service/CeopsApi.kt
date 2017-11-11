package br.com.robertodebarba.floodmonitoring.consumer.ceops.service

enum class CeopsApi(val url: String) {

    BLUMENAU("http://ceops.furb.br/restrito/SisCeops/controllers/controller_pg.php?action=tabela_dados&&cd_estacao=7331"),
    FLOOD_HISTORY("http://ceops.furb.br/wappers/Historico_Enchentes/Tabela%20Enchente.html")
}