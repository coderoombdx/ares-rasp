package com.coderoom.ares.domain.model

sealed interface OnOff {
    object On : OnOff
    object Off : OnOff
}
