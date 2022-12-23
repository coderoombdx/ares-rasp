package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceGestionDuTemps
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/compteARebours")
class CompteAReboursApi(
    private val serviceGestionDuTemps: ServiceGestionDuTemps
) {
    @Operation(
        summary = "Modifie le compte à rebours. Sans argument, une minute supplémentaire est donnée aux joueurs.",
        description = "200"
    )
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "")])
    @PostMapping
    fun updateCompteARebours(
        @RequestBody compteARebours: CompteARebours?
    ): ResponseEntity<Any> {
        serviceGestionDuTemps.updateCompteARebours(compteARebours?.delta)
        return ResponseEntity(HttpStatus.OK)
    }

    @Operation(summary = "Réinitialiser le jeu. Doit être appelé au top départ", description = "200")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "")])
    @DeleteMapping
    fun resetJeu(): ResponseEntity<Any> {
        serviceGestionDuTemps.resetCompteARebours()
        return ResponseEntity(HttpStatus.OK)
    }
}

data class CompteARebours(
    val delta: Int? = null,
)