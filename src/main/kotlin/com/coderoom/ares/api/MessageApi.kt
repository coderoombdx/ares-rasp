package com.coderoom.ares.api

import com.coderoom.ares.domain.service.ServiceMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageApi(
    private val serviceMessage: ServiceMessage
) {
    @PostMapping("/api/messageAide")
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