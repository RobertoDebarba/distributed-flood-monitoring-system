package br.com.robertodebarba.floodmonitoring.api

import org.glassfish.jersey.server.ResourceConfig

class FloodMonitoringApp : ResourceConfig() {
    init {
        register(FloofMonitoringAppBinder())
        packages(true, "br.com.robertodebarba.floodmonitoring.api")
    }

}
