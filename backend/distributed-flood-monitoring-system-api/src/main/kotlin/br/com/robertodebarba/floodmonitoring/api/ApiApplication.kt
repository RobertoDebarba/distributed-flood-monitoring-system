package br.com.robertodebarba.floodmonitoring.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@ComponentScan(basePackages = arrayOf(
        "br.com.robertodebarba.floodmonitoring.api"
))
@EnableMongoRepositories(basePackages = arrayOf(
        "br.com.robertodebarba.floodmonitoring.core.entity"
))
class ApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}