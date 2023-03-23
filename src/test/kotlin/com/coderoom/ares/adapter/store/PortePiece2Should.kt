package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PortePiece2Should {

    @Test
    fun `calculer correctement le code`() {

        val context = Jeu(
            compteARebours = 0,
            messageAide = "",
            derniereAlarme = 12,
            interrupteurGeneral = true,
            modules = listOf(),
            heureMartienne = 0
        )

        assertEquals("6645", Enigme.SegmentRadioHorloge.code(context.copy(heureMartienne = 45 * 60))) // "00:45"
        assertEquals("6657", Enigme.SegmentRadioHorloge.code(context.copy(heureMartienne = 28 * 60)))  // "00:28"
    }
}