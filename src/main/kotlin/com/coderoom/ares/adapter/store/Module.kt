package com.coderoom.ares.adapter.store

sealed class Module(
    val id: String,
    val enigmes: List<Enigme>
)

object ModuleExterieur : Module(
    id = "exterieur",
    enigmes = listOf(
        Enigme.CablePhotovoltaique,
        Enigme.InterrupteurGeneral,
        Enigme.PorteExterieur
    )
)

object ModuleInterieur1 : Module(
    id = "interieur1",
    enigmes = listOf(
        Enigme.PortePiece1,
    )
)

object ModuleInterieur2 : Module(
    id = "interieur2",
    enigmes = listOf(
        Enigme.PortePiece2,
    )
)
