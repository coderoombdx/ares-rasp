package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.api.model.Jeu as JeuApiModel
import com.coderoom.ares.api.model.Scenario1 as Scenario1ApiModel
import com.coderoom.ares.api.model.Scenario2 as Scenario2ApiModel


fun Jeu.toApiModel() = JeuApiModel(
    compteARebours = this.compteARebours,
    dernierMessage = this.dernierMessage,
    electriciteGenerale = this.electriciteGenerale.toApiModel(),
    derniereAlarme = this.derniereAlarme,
    scenario1 = Scenario1ApiModel(
        porte1 = this.scenario1.porte1.toApiModel()
    ),
    scenario2 = Scenario2ApiModel(
        porte1 = this.scenario2.porte1.toApiModel()
    )
)
