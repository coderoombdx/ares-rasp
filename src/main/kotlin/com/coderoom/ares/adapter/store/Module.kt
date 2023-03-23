package com.coderoom.ares.adapter.store

sealed class Module(
    val id: String,
    val description: String,
    val idScenario: String,
    val enigmes: List<Enigme>
)

// Scenario 1
//
object ModuleExterieur : Module(
    id = "exterieur",
    description = "Module extérieur",
    idScenario = "1",
    enigmes = listOf(
        Enigme.CablePhotovoltaique,
        Enigme.PorteExterieur
    )
)

object ModuleSegmentHorloge : Module(
    id = "segment_horloge",
    description = "Le code correspond au segments de leds affichés par un radio réveil dans le jeu",
    idScenario = "1",
    enigmes = listOf(
        Enigme.SegmentRadioHorloge,
    )
)

// Scenario 2
//
object ModuleSystemSolaire : Module(
    id = "system_solaire",
    description = "Ordonné les planètes grâces a la composition de l'atmosphère",
    idScenario = "2",
    enigmes = listOf(
        Enigme.PortePiece1,
    )
)

object ModuleSeulSurMars : Module(
    id = "seul_sur_mars",
    description = "Trouver le code grâce au livre seul sur mars",
    idScenario = "2",
    enigmes = listOf(
        Enigme.PortePieceSeulSurMars,
    )
)
