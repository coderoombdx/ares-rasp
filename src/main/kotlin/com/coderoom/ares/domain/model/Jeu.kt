package com.coderoom.ares.domain.model

data class Jeu(
    val compteARebours: Int,
    val messageAide: String?,
    val derniereAlarme: Int,
    val interrupteurGeneral: Boolean,
    val heureMartienneEnSecondes: Int,
    var fishingDoorStart: Int,
    val modules: List<Module>,
) {
    fun getEnigme(id: String) = this.modules.map { it.enigmes }.flatten().firstOrNull { it.id == id }

    // TODO GPT L'heure du radio reveil n'est pas mise à jour
}
