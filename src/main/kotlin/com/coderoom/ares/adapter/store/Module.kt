package com.coderoom.ares.adapter.store

sealed class Module(
    val id: String,
    val enigmes: List<Enigme>
)

object ModuleExterieur : Module(
    id = "exterieur",
    enigmes = listOf(
        EnigmeCablePhotovoltaique,
        EnigmeInterrupteurGeneral
    )
)
