package br.com.robertodebarba.floodmonitoring.consumer.ceops.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class CeopsRecord(val cd_estacao: Int = 0,
                       val ds_cidade: String = "",
                       val data: String = "",
                       val vlr_nivel: Float = 0F,
                       val vlr_precipitacao: Float = 0F,
                       val ds_ativo_nivel: Boolean = false,
                       val ds_ativo_chuva: Boolean = false,
                       val status: String = "") {

    class Deserializer : ResponseDeserializable<Array<CeopsRecord>> {
        override fun deserialize(content: String) = Gson().fromJson(content, Array<CeopsRecord>::class.java)
    }

}