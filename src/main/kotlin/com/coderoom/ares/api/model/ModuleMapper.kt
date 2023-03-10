package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Enigme
import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.domain.model.Module
import com.coderoom.ares.api.model.Module as ModuleApiModel

fun Module.toApiModel(jeu: Jeu) = ModuleApiModel(
    id = this.id,
    description = this.description,
    idScenario = this.idScenario,
    etat = this.enigmes.toEtatModule(),
    enigmes = this.enigmes.map { it.toApiModel(jeu) }
)

private fun List<Enigme>.toEtatModule(): ModuleApiModel.Etat {
    val (enigmesResolues, enigmesNonResolues) = this.partition { it.resolu }
    return if (enigmesResolues.isEmpty()) {
        ModuleApiModel.Etat.ADEBUTER
    } else if (enigmesNonResolues.isEmpty()) {
        ModuleApiModel.Etat.TERMINE
    } else {
        ModuleApiModel.Etat.ENCOURS
    }
}

