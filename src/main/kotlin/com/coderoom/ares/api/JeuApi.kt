package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.StoreRepository
import com.coderoom.ares.api.model.toApiModel
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/jeu")
class JeuApi(
    private val storeRepository: StoreRepository
) {
    @Operation(summary = "Envoie un etat du jeu", description = "200")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "")])
    @GetMapping
    fun allStatus(): ResponseEntity<Any> {
        return ResponseEntity(storeRepository.getJeu().toApiModel(System.currentTimeMillis()), HttpStatus.OK)
    }
}