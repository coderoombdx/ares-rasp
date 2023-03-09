package com.coderoom.ares.api

import com.coderoom.ares.adapter.drone.DroneRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/vol")
class DroneApi(
    private val droneRepository: DroneRepository
) {
    @Operation(summary = "Déclenche le vol du drone", description = "200 si ok")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Vol lancé"),
            ApiResponse(responseCode = "304", description = "le vol est en cours"),
        ]
    )
    @PostMapping
    fun launchFlight(): ResponseEntity<Any> {
        val returnStatus = if (droneRepository.lanceVol()) {
            HttpStatus.OK
        } else {
            HttpStatus.NOT_MODIFIED
        }
        return ResponseEntity(returnStatus)
    }
}
