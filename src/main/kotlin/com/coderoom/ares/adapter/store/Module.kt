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

object ModuleHallEntree : Module(
    id = "hall_entree",
    description = "Hall d'entrée",
    idScenario = "1",
    enigmes = listOf(
        Enigme.SegmentHorlogeRadio,
    )
)

object ModuleSecuriteRoot : Module(
    id = "capcom_room",
    description = "Piece Capcom",
    idScenario = "1",
    enigmes = listOf(
        Enigme.FishingRootTerminalRoot,
        Enigme.FishingRootDoorStart,
        Enigme.FishingRootDoorOpen,
    )
)

object ModuleLevier : Module(
    id = "levier",
    description = "Derniere salle",
    idScenario = "1",
    enigmes = listOf(
        Enigme.Levier,
    )
)

object ModuleRSE : Module(
    id = "secu_root",
    description = "mettre les images dans le bon scope",
    idScenario = "1",
    enigmes = listOf(
//        Enigme.SegmentRadioHorloge,
    )
)

object ModuleSecuGPT : Module(
    id = "secu_gpt",
    description = "Hacker un LLM",
    idScenario = "1",
    enigmes = listOf(
    )
)

// Scenario 2
//
object ModuleLumiereStation : Module(
    id = "lumiere_station",
    description = "Mettre la carte RFID sur le tableau de commande",
    idScenario = "2",
    enigmes = listOf(
        Enigme.InterrupteurGeneral,
    )
)

object ModuleSystemSolaire : Module(
    id = "systeme_solaire",
    description = "Ordonner les planètes grâces a la composition de l'atmosphère",
    idScenario = "2",
    enigmes = listOf(
        Enigme.PorteSystemSolaire,
    )
)

object ModuleSeulSurMars : Module(
    id = "seul_sur_mars",
    description = "Trouver le code grâce au livre seul sur mars 1976",
    idScenario = "2",
    enigmes = listOf(
        Enigme.PortePieceSeulSurMars,
    )
)

object ModuleSecuritePasswd : Module(
    id = "secu_password",
    description = "La porte s'ouvre au bout de 3 minutes, s'ils donnent le passwd, ils perdent",
    idScenario = "2",
    enigmes = listOf(
        Enigme.FishingPasswordTerminal,
        Enigme.FishingPasswordDoorStart,
        Enigme.FishingPasswordDoorOpen,
    )
)

object ModuleHautsParleur : Module(
    id = "haut_parleur",
    description = "Un message est diffusé qui donne un code",
    idScenario = "2",
    enigmes = listOf(
        Enigme.PorteHautParleur
    )
)

