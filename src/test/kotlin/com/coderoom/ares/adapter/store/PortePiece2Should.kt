package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu
import org.junit.jupiter.api.Test

class PortePiece2Should {

    @Test
    fun `calculer correctement le code`() {

        val context = Jeu(
            compteARebours = 0,
            messageAide = "",
            derniereAlarme = 12,
            interrupteurGeneral = true,
            heureMartienneEnSecondes = 0,
            fishingDoorStart = 0,
            modules = listOf(),
            terraformation = false
        )
    }
}