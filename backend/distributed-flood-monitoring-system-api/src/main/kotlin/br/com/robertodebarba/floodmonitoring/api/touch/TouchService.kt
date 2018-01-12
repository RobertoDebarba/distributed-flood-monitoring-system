package br.com.robertodebarba.floodmonitoring.api.touch

import org.apache.commons.mail.DefaultAuthenticator
import org.apache.commons.mail.SimpleEmail
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TouchService {

    @Value("\${email}")
    private lateinit var email: String

    @Value("\${password}")
    private lateinit var password: String

    @Value("\${sendTo}")
    private lateinit var sendTo: String

    fun postTouch(touchDTO: TouchDTO) {
        SimpleEmail().apply {
            hostName = "smtp.live.com"
            isStartTLSEnabled = true
            setSmtpPort(25)
            setAuthenticator(DefaultAuthenticator(email, password))

            setFrom(email)
            subject = "[CLIMA ALERTA] Nova mensagem de ${touchDTO.name}"
            setMsg("${touchDTO.name} <${touchDTO.email}> enviou uma mensagem:\n\n${touchDTO.message}")
            addTo(sendTo)
        }.send()
    }
}