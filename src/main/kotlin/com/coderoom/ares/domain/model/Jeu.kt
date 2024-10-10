package com.coderoom.ares.domain.model

data class Jeu(
    val compteARebours: Int,
    val messageAide: String?,
    val derniereAlarme: Int,
    var interrupteurGeneral: Boolean,
    var terraformation: Boolean,
    val heureMartienneEnSecondes: Int,
    var timestampFishingMotDePass: Long,
    var timestampFishingUtilisateur: Long,
    val modules: List<Module>
) {
    fun getEnigme(id: String) = this.modules.map { it.enigmes }.flatten().firstOrNull { it.id == id }

    // TODO GPT L'heure du radio reveil n'est pas mise à jour
}
