package com.coderoom.ares.api.model

import com.coderoom.ares.adapter.store.Enigme.Companion.ID_INTER_GENERAL
import com.coderoom.ares.adapter.store.Module.Companion.ID_SCENARIO_2
import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.api.model.Jeu as JeuApiModel

fun Jeu.toApiModel(currentTimeMillis: Long): JeuApiModel {
    val secondesRestantes = this.heureMartienneEnSecondes.toLong()
    val heuresRestantes = secondesRestantes / 3600
    val minutesRestantes = (secondesRestantes % 3600) / 60
    val interupteurForce = this.modules.first { it.idScenario == ID_SCENARIO_2 }.enigmes.any { it.id == ID_INTER_GENERAL && it.resolu }

    return JeuApiModel(
        timestampFinDuJeu = (currentTimeMillis / 1000) + this.compteARebours,
        compteARebours = this.compteARebours,
        messageAide = this.messageAide,
        derniereAlarme = this.derniereAlarme,
        interrupteurGeneral = this.interrupteurGeneral,
        terraformation = this.terraformation,
        heureMartienne = String.format("%02d:%02d", heuresRestantes, minutesRestantes),
        modules = this.modules.map { it.toApiModel(this) },
        timestampFishingMotDePass = this.timestampFishingMotDePass,
        timestampFishingUtilisateur = this.timestampFishingMotDePass,
    )
}