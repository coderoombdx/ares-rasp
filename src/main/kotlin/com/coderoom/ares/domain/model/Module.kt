package com.coderoom.ares.domain.model

data class Module(
    val id: String,
    val description: String,
    val idScenario: String,
    val enigmes: List<Enigme>
)
