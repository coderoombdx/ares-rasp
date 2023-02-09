package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.StoreRepository
import com.coderoom.ares.domain.model.OuvertFerme
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/portes/")
class PorteApi(
    private val storeRepository: StoreRepository
) {
    @Operation(
        summary = "Donne la liste des portes",
        description = "Retourne la liste des portes avec, leur id, leur status et leur code"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = ""),
        ]
    )
    @GetMapping
    fun getPortes(): ResponseEntity<List<Porte>> {
        return ResponseEntity(
            listOf(Porte(id = "portePrincipale", etat = OuvertFerme.Ferme, code = "1234")),
            HttpStatus.OK
        )
    }

    @Operation(
        summary = "Ouvre la porte {idPorte}",
        description = "Si le code est correct, la code retourné est 200, sinon 403"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "L'action sur la porte s'est passé sans problème"),
            ApiResponse(responseCode = "400", description = "L'action n'est pas possible"),
            ApiResponse(
                responseCode = "403",
                description = "L'action sur la porte n'a pas pu être effectuée, mauvaise code"
            ),
            ApiResponse(responseCode = "404", description = "La porte n'existe pas"),
        ]
    )
    @PostMapping("{idPorte}")
    fun gerePorte(
        @PathVariable idPorte: String,
        @RequestBody actionPorte: ActionPorte
    ): ResponseEntity<Nothing> {
        return ResponseEntity(HttpStatus.OK)
    }
}

data class ActionPorte(
    val action: Action,
    val code: String?,
) {
    enum class Action(val action: String) {
        OUVRE("Ouvre"),
        FERME("Ferme")
    }
}

data class Porte(
    val id: String,
    val etat: OuvertFerme,
    val code: String?,
)