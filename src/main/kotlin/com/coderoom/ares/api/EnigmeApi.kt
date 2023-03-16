package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.EnigmeResult
import com.coderoom.ares.adapter.store.StoreRepository
import com.coderoom.ares.api.model.EnigmeProposition
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/enigmes")
class EnigmeApi(
    private val storeRepository: StoreRepository
) {
    @Operation(summary = "Envoie la réponse d'une énigme")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "L'énigme est résolue"),
            ApiResponse(responseCode = "404", description = "L'id de l'énigme n'existe pas"),
            ApiResponse(responseCode = "403", description = "La réponse à l'énigme n'est pas correcte")]
    )
    @PostMapping("/{id}")
    fun resoutEnigme(
        @PathVariable(required = true) id: String,
        @RequestBody(required = false) enigmeProposition: EnigmeProposition
    ): ResponseEntity<Any> {
        return when (storeRepository.setEnigme(id, enigmeProposition.code)) {
            EnigmeResult.Success -> ResponseEntity(HttpStatus.OK)
            EnigmeResult.NotFound -> ResponseEntity(HttpStatus.NOT_FOUND)
            EnigmeResult.Failure -> ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }

    @Operation(summary = "Reset une énigme")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "L'énigme est forcée à non résolue"),
            ApiResponse(responseCode = "404", description = "L'id de l'énigme n'existe pas")]
    )
    @DeleteMapping("/{id}")
    fun resetEnigme(
        @PathVariable(required = true) id: String
    ): ResponseEntity<Unit> {
        return when (storeRepository.resetEnigme(id)) {
            EnigmeResult.Success -> ResponseEntity(HttpStatus.OK)
            EnigmeResult.NotFound -> ResponseEntity(HttpStatus.NOT_FOUND)
            EnigmeResult.Failure -> ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }

}