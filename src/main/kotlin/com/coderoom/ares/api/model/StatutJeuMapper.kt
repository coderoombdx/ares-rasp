package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.api.model.Jeu as JeuApiModel
import com.coderoom.ares.api.model.Scenario1 as Scenario1ApiModel
import com.coderoom.ares.api.model.Scenario2 as Scenario2ApiModel


fun Jeu.toApiModel(currentTimeMillis: Long) = JeuApiModel(
    timestampFinDuJeu = (currentTimeMillis / 1000) + this.compteARebours,
    compteARebours = this.compteARebours,
    messageAide = this.messageAide,
    electriciteGenerale = this.electriciteGenerale.toApiModel(),
    derniereAlarme = this.derniereAlarme,
    scenario1 = Scenario1ApiModel(
        porte1 = this.scenario1.porteExterieure.toApiModel()
    ),
    scenario2 = Scenario2ApiModel(
        porte1 = this.scenario2.porte1.toApiModel()
    )
)
