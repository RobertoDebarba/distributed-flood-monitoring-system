package br.com.robertodebarba.floodmonitoring.api.dashboard

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DashboardApi {

    @Autowired
    lateinit var service: DashboardService

    @CrossOrigin
    @RequestMapping("dashboard")
    fun getDashboard(): DashboardDTO {
        return service.getDashboard()
    }
}