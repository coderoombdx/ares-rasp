package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.domain.model.Scenario1
import com.coderoom.ares.domain.model.Scenario2

fun StoreSingleton.toJeu() = Jeu(
    compteARebours = compteARebours,
    dernierMessage = dernierMessage,
    electriciteGenerale = electriciteGenerale,
    derniereAlarme = derniereAlarme,
    scenario1 = Scenario1(
        porte1 = scenario1.porte1
    ),
    scenario2 = Scenario2(
        porte1 = scenario2.porte1
    )
)
