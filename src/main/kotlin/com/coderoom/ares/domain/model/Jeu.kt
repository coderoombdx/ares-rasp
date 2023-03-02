package com.coderoom.ares.domain.model

data class Jeu(
    val compteARebours: Int,
    val messageAide: String?,
    val derniereAlarme: Int,
    val modules: List<Module>,
)
