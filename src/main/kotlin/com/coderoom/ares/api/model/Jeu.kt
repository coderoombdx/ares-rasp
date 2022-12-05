package com.coderoom.ares.api.model

data class Jeu(
    val compteARebours: Int,
    val dernierMessage: String,
    val electriciteGenerale: OnOff,
    val derniereAlarme: Int,
    val scenario1: Scenario1,
    val scenario2: Scenario2
)