package com.coderoom.ares.api

import com.coderoom.ares.api.model.toApiModel
import com.coderoom.ares.adapter.store.StoreRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class EtatJeuApi(
    private val storeRepository: StoreRepository
) {
    @GetMapping("/etat")
    fun allStatus(): ResponseEntity<Any> {
        return ResponseEntity(storeRepository.getEtatJeu().toApiModel(), HttpStatus.OK)
    }
}