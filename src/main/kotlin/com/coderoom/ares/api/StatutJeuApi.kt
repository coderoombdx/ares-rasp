package com.coderoom.ares.api

import com.coderoom.ares.model.EtatPorte
import com.coderoom.ares.model.StatutJeu
import com.coderoom.ares.repository.StatusSingleton
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class StatutJeuApi {
    @GetMapping("/statut")
    fun allStatus(): ResponseEntity<Any> {
        return ResponseEntity(
            StatutJeu(
                stationEclairee = true,
                porte1 = EtatPorte.FERME,
                data = StatusSingleton.data
            ),
            HttpStatus.OK
        )
    }
}