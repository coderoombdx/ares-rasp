package com.coderoom.ares.domain.model

data class Jeu(
    val compteARebours: Int,
    val messageAide: String?,
    val electriciteGenerale: OnOff,
    val derniereAlarme: Int,
    val scenario1: Scenario1,
    val scenario2: Scenario2,
)
