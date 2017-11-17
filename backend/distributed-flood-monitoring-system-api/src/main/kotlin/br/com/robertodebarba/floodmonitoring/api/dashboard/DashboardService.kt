package br.com.robertodebarba.floodmonitoring.api.dashboard

import br.com.robertodebarba.floodmonitoring.api.riverlevel.RiverLevelMapper
import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RainFallRepository
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DashboardService {

    @Autowired
    lateinit var riverLevelRepository: RiverLevelRepository

    @Autowired
    lateinit var rainFallRepository: RainFallRepository

    @Autowired
    lateinit var dashboardMapper: DashboardMapper

    @Autowired
    lateinit var riverLevelMapper: RiverLevelMapper

    fun getDashboard(): DashboardDTO {
        val riverLevel = this.riverLevelRepository.findFirst1ByOrderByTimeDesc()
        val rainIntensity = rainIntensity {
            this.rainFallRepository.findFirst1ByOrderByTimeDesc()
        }
        val riverStatus = riverStatus {
            riverLevel
        }
        val levelsHistoric = riverLevelRepository.findFirst20ByOrderByTimeDesc()
        val riverLevelHistoric = levels {
            levelsHistoric
        }
        val riverLevelHistoricTimes = times{
            levelsHistoric
        }

        return DashboardDTO(riverLevel.level, rainIntensity, riverStatus, riverLevelHistoric, riverLevelHistoricTimes)
    }

    private fun rainIntensity(block: () -> RainFall) = dashboardMapper.toRainIntensity(block())

    private fun riverStatus(block: () -> RiverLevel) = dashboardMapper.toRiverStatus(block())

    private fun levels(producer: () -> List<RiverLevel>): List<Float> =
            producer().map { riverLevelMapper.toDTO(it).level }

    private fun times(producer: () -> List<RiverLevel>): List<LocalDateTime> =
            producer().map { riverLevelMapper.toDTO(it).time }
}