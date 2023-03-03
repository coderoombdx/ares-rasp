package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.StoreRepository
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
class EngimeApi(
    private val storeRepository: StoreRepository
) {
    @Operation(summary = "Envoie la réponse d'une enigme")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "L'enigme est résolue"),
            ApiResponse(responseCode = "404", description = "L'id de l'enigme n'existe pas"),
            ApiResponse(responseCode = "403", description = "La réponse à l'enigme n'est pas correcte")]
    )
    @PostMapping("/{id}")
    fun resousEnigme(
        @PathVariable(required = true) id: String,
        @RequestBody(required = false) solution: String?
    ): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "Reset une enigme")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "L'enigme est résolue"),
            ApiResponse(responseCode = "404", description = "L'id de l'enigme n'existe pas")]
    )
    @DeleteMapping("/{id}")
    fun resetEnigme(
        @PathVariable(required = true) id: String
    ): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }

}