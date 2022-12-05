package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceCompterARebours
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class CompteAReboursApi(
    private val serviceCompterARebours: ServiceCompterARebours
) {
    @PostMapping("/api/compteARebours")
    fun updateCompteARebours(
        @RequestBody compteARebours: CompteARebours?
    ): ResponseEntity<Any> {
        serviceCompterARebours.updateCompteARebours(compteARebours?.delta)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/api/compteARebours")
    fun resetCompteARebours(): ResponseEntity<Any> {
        serviceCompterARebours.resetCompteARebours()
        return ResponseEntity(HttpStatus.OK)
    }
}

data class CompteARebours(
    val delta: Int? = null,
)