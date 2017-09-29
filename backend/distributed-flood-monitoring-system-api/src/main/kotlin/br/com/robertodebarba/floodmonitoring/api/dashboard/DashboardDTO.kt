package br.com.robertodebarba.floodmonitoring.api.dashboard

class DashboardDTO(val riverLevel: Float,
                   val rainIntensity: RainIntensity,
                   val riverStatus: RiverStatus,
                   val riverLevelHistoric: List<Float>)