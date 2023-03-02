package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Enigme
import com.coderoom.ares.api.model.Enigme as EnigmeApiModel

fun Enigme.toApiModel() = EnigmeApiModel(
    id = this.id,
    description = this.description,
    resolu = this.resolu,
    code = this.code,
)
