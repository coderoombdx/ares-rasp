package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.StoreRepository
import com.coderoom.ares.api.model.toApiModel
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Operation(summary = "Envoie un état du jeu", description = "200")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "")])
    @GetMapping
    fun getJeu(): ResponseEntity<Any> {
        logger.info("Get jeu")
        return ResponseEntity(storeRepository.getJeu().toApiModel(System.currentTimeMillis()), HttpStatus.OK)
    }

    // TODO faire put de /api/jeu pour seter un parametre donné. Exemple /api/jeu/ modifie n'importe quoi dans jeu
}