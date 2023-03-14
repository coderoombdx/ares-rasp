package com.coderoom.ares.adapter.store

sealed class Module(
    val id: String,
    val description: String,
    val idScenario: String,
    val enigmes: List<Enigme>
)

object ModuleExterieur : Module(
    id = "exterieur",
    description = "Module extérieur",
    idScenario = "1",
    enigmes = listOf(
        Enigme.CablePhotovoltaique,
        Enigme.PorteExterieur
    )
)

object ModuleInterieur1 : Module(
    id = "interieur1",
    description = "Module Intérieur",
    idScenario = "1",
    enigmes = listOf(
        Enigme.InterrupteurGeneral,
        Enigme.PortePiece1,
    )
)

object ModuleInterieur2 : Module(
    id = "interieur2",
    description = "Module Intérieur",
    idScenario = "2",
    enigmes = listOf(
        Enigme.InterrupteurGeneral,
        Enigme.PortePiece2,
    )
)
