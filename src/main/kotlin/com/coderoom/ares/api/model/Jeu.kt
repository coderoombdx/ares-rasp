package com.coderoom.ares.api.model

data class Jeu(
    val compteARebours: Int,
    val timestampFinDuJeu: Long,
    val messageAide: String?,
    val derniereAlarme: Int,
    val interrupteurGeneral: Boolean,
    val heureMartienne: String,
    val modules: List<Module>,
    val terraformation: Boolean,
)