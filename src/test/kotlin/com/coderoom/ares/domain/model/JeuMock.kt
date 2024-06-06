package com.coderoom.ares.domain.model

import com.coderoom.ares.TimeConstants


internal class JeuMock {
    companion object {
        fun default() = Jeu(
            compteARebours = 0,
            messageAide = "message",
            derniereAlarme = 0,
            interrupteurGeneral = true,
            heureMartienneEnSecondes = TimeConstants.heureSurMars,
            fishingDoorStart = 0,
            modules = listOf(
                ModuleMock.exterieur(),
                ModuleMock.interieur1(),
                ModuleMock.interieur2()
            )
        )
    }
}