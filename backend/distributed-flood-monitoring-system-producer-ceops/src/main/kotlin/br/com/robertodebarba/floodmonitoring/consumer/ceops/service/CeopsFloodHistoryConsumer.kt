package br.com.robertodebarba.floodmonitoring.consumer.ceops.service

import br.com.robertodebarba.floodmonitoring.consumer.ceops.queue.QueuePublisher
import br.com.robertodebarba.floodmonitoring.consumer.ceops.service.CeopsApi.FLOOD_HISTORY
import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class CeopsFloodHistoryConsumer {

    private val logger = LoggerFactory.getLogger(this.javaClass)!!

    @Autowired
    private lateinit var floodPublisher: QueuePublisher<Flood>

    @Scheduled(cron = "\${floodHistoryCron}")
    fun consume() {
        val document = Jsoup.connect(FLOOD_HISTORY.url).get()
        logger.info("Request ${CeopsApi.FLOOD_HISTORY.url}: 200 OK")

        parseHtml(document).forEach { floodPublisher.publish(it) }
    }

    /**
     * Formato do documento lido:
     *
     * <table>
     *     <caption>Picos de Enchentes Registrados na Bacia do Rio Itajaí-Açú</caption>
     *     <thead>
     *         <tr><th rowspan="2">Ano</th><th rowspan="2">Data</th><th colspan="9">Cidade</th></tr>
     *         <tr><th>Apiuna</th><th>Blumenau</th><th>Brusque</th><th>Gaspar </th><th>Ibirama</th><th>Indaial</th><th>Rio do Sul</th><th>Salto</th><th>Timbo</th></tr>
     *     </thead>
     *     <tbody>
     *         <tr><td>1852</td><td data-date="10/29/1852" title="29 de outubro de 1852">29/10</td><td></td><td data-level="16.3">16,3m</td><td></td><td></td><td></td><td data-level="8.3">8,3m</td><td></td><td data-level="19">19m</td><td></td></tr>
     *         <tr><td>1855</td><td data-date="11/20/1855" title="20 de novembro de 1855">20/11</td><td></td><td data-level="13.3">13,3m</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
     *         <tr><td>1862</td><td data-date="11/20/1862" title="20 de novembro de 1862">20/11</td><td></td><td data-level="9">9m</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
     */
    private fun parseHtml(document: Document): ArrayList<Flood> {
        val floodsTableHeader = document.getElementsByTag("table").first().child(1).child(1)
        val floodsTableBody = document.getElementsByTag("table").first().child(2)

        val floodsData = floodsTableBody.children()
                .filter { it -> !isFloodGroupTitle(it) }

        val cities = MutableList(floodsTableHeader.childNodeSize()) { index -> floodsTableHeader.child(index).text() }
        val floods = ArrayList<Flood>()

        floodsData.forEach {
            val state = "SC"
            val date = getDate(it)

            it.children().forEachIndexed { index, floodData ->

                if (isLevelData(floodData)) {

                    val level = floodData.attr("data-level").toFloat()
                    val city = getCityNameByIndex(cities, index)

                    floods.add(Flood(city = city,
                            federationUnit = state,
                            level = level,
                            date = date ?: LocalDate.MIN))
                }
            }
        }

        return floods
    }

    private fun isFloodGroupTitle(it: Element) = it.className() == "decade"

    private fun isLevelData(floodData: Element) = floodData.hasAttr("data-level")

    private fun getDate(it: Element): LocalDate? {
        val datePattern = DateTimeFormatter.ofPattern("d/MM/yyyy")

        val year = it.child(0).text()
        val date = it.child(1).text() + "/$year"

        return LocalDate.parse(date, datePattern)
    }

    private fun getCityNameByIndex(cities: MutableList<String>, index: Int) =
            cities[index - 2]
}