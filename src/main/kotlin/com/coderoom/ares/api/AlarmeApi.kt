package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceGestionDuTemps
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/alarme")
class AlarmeApi(
    private val serviceGestionDuTemps: ServiceGestionDuTemps
) {
    @Operation(
        summary = "Déclanche une alarme qui sera consommé par unreal pour stresser les joueurs",
        description = "200"
    )
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "")])
    @DeleteMapping
    fun resetAlarme(): ResponseEntity<Any> {
        serviceGestionDuTemps.resetAlarme()
        return ResponseEntity(HttpStatus.OK)
    }
}
