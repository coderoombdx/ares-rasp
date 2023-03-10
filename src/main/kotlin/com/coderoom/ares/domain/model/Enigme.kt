package com.coderoom.ares.domain.model

data class Enigme(
    val id: String,
    val description: String,
    var resolu: Boolean,
    val code: (Jeu) -> String?
)