package br.com.robertodebarba.floodmonitoring.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ApplicationExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(IllegalApiArgumentException::class)
    protected fun handleIllegalApiArgumentException(ex: IllegalApiArgumentException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ex.message)
    }

    @ExceptionHandler(Exception::class)
    protected fun handleGenericException(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.message)
    }

}