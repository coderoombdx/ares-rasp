package com.coderoom.ares.domain.model

data class Enigme(
    val id: String,
    val description: String,
    val resolu: Boolean,
    val code: String?
)