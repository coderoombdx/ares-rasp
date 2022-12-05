package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.OnOff as OnOffModel

fun OnOffModel.toApiModel(): OnOff {
    return when (this) {
        OnOffModel.Off -> OnOff.OFF
        OnOffModel.On -> OnOff.ON
    }
}

enum class OnOff(val value: String) {
    ON("ON"),
    OFF("OFF")
}


