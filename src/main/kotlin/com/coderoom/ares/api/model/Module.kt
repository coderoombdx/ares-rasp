package com.coderoom.ares.api.model

data class Module(
    val id: String,
    val description: String,
    val idScenario: String,
    val etat: Etat,
    val enigmes: List<Enigme>
) {
    enum class Etat {
        ENCOURS,
        TERMINE,
        ADEBUTER,
    }
}
