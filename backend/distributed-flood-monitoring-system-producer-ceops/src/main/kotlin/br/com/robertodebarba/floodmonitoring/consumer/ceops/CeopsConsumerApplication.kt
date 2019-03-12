package br.com.robertodebarba.floodmonitoring.consumer.ceops

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@Configuration
@EnableScheduling
@ComponentScan(basePackages = arrayOf(
        "br.com.robertodebarba.floodmonitoring.consumer.ceops"
))
class CeopsConsumerApplication

fun main(args: Array<String>) {
    SpringApplication.run(CeopsConsumerApplication::class.java, *args)
}
