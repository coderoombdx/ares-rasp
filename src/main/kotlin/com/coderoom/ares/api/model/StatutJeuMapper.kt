package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.api.model.Jeu as JeuApiModel


fun Jeu.toApiModel(currentTimeMillis: Long) = JeuApiModel(
    timestampFinDuJeu = (currentTimeMillis / 1000) + this.compteARebours,
    compteARebours = this.compteARebours,
    messageAide = this.messageAide,
    derniereAlarme = this.derniereAlarme,
    modules = this.modules.map { it.toApiModel() }
)
