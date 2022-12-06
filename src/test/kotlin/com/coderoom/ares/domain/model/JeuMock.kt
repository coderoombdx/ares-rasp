package com.coderoom.ares.domain.model

internal class JeuMock {
    companion object {
        fun default() = Jeu(
            compteARebours = 0,
            messageAide = "message",
            electriciteGenerale = OnOff.On,
            derniereAlarme = 0,
            scenario1 = Scenario1(porte1 = OuvertFerme.Ouvert),
            scenario2 = Scenario2(porte1 = OuvertFerme.Ferme)
        )
    }
}