package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Module
import com.coderoom.ares.api.model.Module as ModuleApiModel

fun Module.toApiModel() = ModuleApiModel(
    id = this.id,
    enigme = this.enigme.map { it.toApiModel() }
)
