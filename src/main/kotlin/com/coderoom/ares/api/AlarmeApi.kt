package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceGestionDuTemps
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
class AlarmeApi(
    private val serviceGestionDuTemps: ServiceGestionDuTemps
) {
    @DeleteMapping("/api/alarme")
    fun resetAlarme(): ResponseEntity<Any> {
        serviceGestionDuTemps.resetAlarme()
        return ResponseEntity(HttpStatus.OK)
    }
}
