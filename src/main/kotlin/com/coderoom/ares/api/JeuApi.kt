package com.coderoom.ares.api

import com.coderoom.ares.adapter.store.StoreRepository
import com.coderoom.ares.api.model.toApiModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class JeuApi(
    private val storeRepository: StoreRepository
) {
    @GetMapping("/api/jeu")
    fun allStatus(): ResponseEntity<Any> {
        return ResponseEntity(storeRepository.getJeu().toApiModel(), HttpStatus.OK)
    }
}