package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.api.model.Jeu as JeuApiModel

fun Jeu.toApiModel(currentTimeMillis: Long): JeuApiModel {
    val secondesRestantes = this.heureMartienneEnSecondes.toLong()
    val heuresRestantes = secondesRestantes / 3600
    val minutesRestantes = (secondesRestantes % 3600) / 60

    return JeuApiModel(
        timestampFinDuJeu = (currentTimeMillis / 1000) + this.compteARebours,
        compteARebours = this.compteARebours,
        messageAide = this.messageAide,
        derniereAlarme = this.derniereAlarme,
        interrupteurGeneral = this.interrupteurGeneral,
        heureMartienne = String.format("%02d:%02d", heuresRestantes, minutesRestantes),
        modules = this.modules.map { it.toApiModel(this) }
    )
}