package br.com.robertodebarba.floodmonitoring.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationController {

    @RequestMapping("/")
    fun helloWorld() = "Hello World"

}