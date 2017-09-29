package br.com.robertodebarba.floodmonitoring.api.dashboard

import br.com.robertodebarba.floodmonitoring.api.dashboard.RainIntensity.*
import br.com.robertodebarba.floodmonitoring.api.dashboard.RiverStatus.*
import br.com.robertodebarba.floodmonitoring.core.entity.RainFall
import br.com.robertodebarba.floodmonitoring.core.entity.RiverLevel
import org.springframework.stereotype.Component

@Component
class DashboardMapper {

    fun toRainIntensity(rainFall: RainFall): RainIntensity {
        return when {
            rainFall.intensity <= 5 -> LIGHT
            rainFall.intensity <= 25 -> MODERATE
            rainFall.intensity <= 50 -> HEAVY
            else -> VERY_STRONG
        }
    }

    fun toRiverStatus(riverLevel: RiverLevel): RiverStatus {
        return when {
            riverLevel.level <= 4 -> NORMAL
            riverLevel.level <= 6 -> ATTENTION
            riverLevel.level <= 8 -> ALERT
            else -> READINESS
        }
    }

}