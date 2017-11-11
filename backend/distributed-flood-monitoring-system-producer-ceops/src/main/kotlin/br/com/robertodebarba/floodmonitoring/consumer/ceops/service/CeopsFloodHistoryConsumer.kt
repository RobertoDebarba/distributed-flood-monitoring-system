package br.com.robertodebarba.floodmonitoring.consumer.ceops.service

import br.com.robertodebarba.floodmonitoring.consumer.ceops.queue.QueuePublisher
import br.com.robertodebarba.floodmonitoring.consumer.ceops.service.CeopsApi.FLOOD_HISTORY
import br.com.robertodebarba.floodmonitoring.core.entity.Flood
import org.jsoup.Jsoup
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

    @Scheduled(cron = "\${cronRequest}")
            //@Scheduled(fixedDelayString = "\${delay}")
    fun consume() {
        val document = Jsoup.connect(FLOOD_HISTORY.url).get()
        logger.info("Request ${CeopsApi.FLOOD_HISTORY.url}: 200 OK")

        val floodsTableHeader = document.getElementsByTag("table").first().child(1).child(1)
        val cities = MutableList(floodsTableHeader.childNodeSize()) { index -> floodsTableHeader.child(index).text() }
        val floods = ArrayList<Flood>()
        val datePattern = DateTimeFormatter.ofPattern("d/MM/yyyy")
        val floodsInfo = document.getElementsByTag("table").first().child(2).children()
                .filter { it -> it.className() != "decade" }

        for (floodInfo in floodsInfo) {
            val floodYear = floodInfo.child(0).text()
            val floodDate = floodInfo.child(1).text() + "/$floodYear"

            floodInfo.children().forEachIndexed { index, it ->
                if (it.hasAttr("data-level")) {
                    val floodLevel = it.attr("data-level")
                    val floodCity = cities[index - 2]
                    floods.add(Flood(year = floodYear.toInt(), city = floodCity, federationUnit = "SC", level = floodLevel.toFloat(),
                            date = LocalDate.parse(floodDate, datePattern).atStartOfDay()))
                }
            }
        }

        TODO("filtrar dados já inseridos")
        floods.forEach { floodPublisher.publish(it) }
    }
}