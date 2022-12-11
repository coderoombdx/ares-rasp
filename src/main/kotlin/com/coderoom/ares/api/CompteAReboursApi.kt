package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceGestionDuTemps
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
class CompteAReboursApi(
    private val serviceGestionDuTemps: ServiceGestionDuTemps
) {
    @PostMapping("/api/compteARebours")
    fun updateCompteARebours(
        @RequestBody compteARebours: CompteARebours?
    ): ResponseEntity<Any> {
        serviceGestionDuTemps.updateCompteARebours(compteARebours?.delta)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/api/compteARebours")
    fun resetCompteARebours(): ResponseEntity<Any> {
        serviceGestionDuTemps.resetCompteARebours()
        return ResponseEntity(HttpStatus.OK)
    }
}

data class CompteARebours(
    val delta: Int? = null,
)