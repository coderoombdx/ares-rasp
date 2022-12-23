package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceMessage
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin
@RequestMapping("/api/messageAide")
class MessageApi(
    private val serviceMessage: ServiceMessage
) {
    @Operation(summary = "Envoie un message d'aide aux joueurs", description = "200")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "")])
    @PostMapping
    fun updateMessage(
        @RequestBody message: Message?
    ): ResponseEntity<Any> {
        serviceMessage.updateMessage(message?.aide)
        return ResponseEntity(HttpStatus.OK)
    }
}

data class Message(
    val aide: String? = null,
)