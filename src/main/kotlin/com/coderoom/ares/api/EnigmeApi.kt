package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.ResetEnigmeResult
import com.coderoom.ares.adapter.store.ResoudreEnigmeResult.*
import com.coderoom.ares.adapter.store.StoreRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

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
        @RequestBody(required = false) solutionProposee: String
    ): ResponseEntity<Unit> {
        return when (val result = storeRepository.setEnigme(id, solutionProposee)) {
            Success -> ResponseEntity<Unit>(HttpStatus.OK).also {
                logger.info("resoutEnigme : résolution OK ($id -> $solutionProposee)")
            }
            NotFound -> ResponseEntity<Unit>(HttpStatus.NOT_FOUND).also {
                logger.info("resoutEnigme : énigme non trouvée ($id)")
            }

            is Failure -> ResponseEntity<Unit>(HttpStatus.FORBIDDEN).also {
                logger.info("resoutEnigme KO ($id -> $solutionProposee != solution: ${result.solution})")
            }

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
            ResetEnigmeResult.Success -> ResponseEntity<Unit>(HttpStatus.OK).also {
                logger.info("resetEnigme : reset OK ($id)")
            }
            ResetEnigmeResult.NotFound -> ResponseEntity<Unit>(HttpStatus.NOT_FOUND).also {
                logger.info("resetEnigme : énigme non trouvée ($id)")
            }
        }
    }

}