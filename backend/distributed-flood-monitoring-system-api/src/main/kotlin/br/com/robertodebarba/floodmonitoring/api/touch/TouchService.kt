package br.com.robertodebarba.floodmonitoring.api.touch

import org.springframework.stereotype.Service

@Service
class TouchService {
    fun postTouch(touchDTO: TouchDTO) {
        println("Mensagem: ${touchDTO.message}")
    }
}