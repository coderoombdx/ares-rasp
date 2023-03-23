package com.coderoom.ares.api.model

data class Jeu(
    val compteARebours: Int,
    val timestampFinDuJeu: Long,
    val messageAide: String?,
    val derniereAlarme: Int,
    val interrupteurGeneral: Boolean,
    val heureMartienne: Int,
    val modules: List<Module>,
)