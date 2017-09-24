package br.com.robertodebarba.floodmonitoring.api

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationApi {

    @CrossOrigin
    @RequestMapping("/")
    fun helloWorld() = "Hello World"

}