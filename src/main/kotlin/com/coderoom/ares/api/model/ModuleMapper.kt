package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Enigme
import com.coderoom.ares.domain.model.Module
import com.coderoom.ares.api.model.Module as ModuleApiModel

fun Module.toApiModel() = ModuleApiModel(
    id = this.id,
    etat = this.enigmes.toEtatModule(),
    enigmes = this.enigmes.map { it.toApiModel() }
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

