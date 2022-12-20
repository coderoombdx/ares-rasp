package com.coderoom.ares.api

import com.coderoom.ares.adapter.drone.DroneRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
class DroneApi(
    private val droneRepository: DroneRepository
) {
    @PostMapping("/api/vol")
    fun launchFlight(): ResponseEntity<Any> {
        val returnStatus = if (droneRepository.lanceVol()) {
            HttpStatus.OK
        } else {
            HttpStatus.NOT_MODIFIED
        }
        return ResponseEntity(returnStatus)
    }

    @DeleteMapping("/api/vol")
    fun resetFlight(): ResponseEntity<Any> {
        droneRepository.relanceVol()
        return ResponseEntity(HttpStatus.OK)
    }
}
