package com.coderoom.ares.adapter.store

sealed class Module(
    val id: String,
    val description: String,
    val idScenario: String,
    val enigmes: List<Enigme>
) {
    companion object {
        const val ID_SCENARIO_1 = "1"
        const val ID_SCENARIO_2 = "2"
    }
}

// Scenario 1
//
object ModuleExterieur : Module(
    id = "exterieur",
    description = "Module extérieur",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.CablePhotovoltaique,
        Enigme.PorteExterieur
    )
)

object ModuleHallEntree : Module(
    id = "hall_entree",
    description = "Hall d'entrée",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.SegmentHorlogeRadio,
    )
)

object ModuleSecuriteRoot : Module(
    id = "capcom_room",
    description = "Piece Capcom",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.FishingRootTerminalRoot,
    )
)

object ModuleLevier : Module(
    id = "levier",
    description = "Derniere salle",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.Levier,
    )
)

object ModuleTerraforming : Module(
    id = "terraforming",
    description = "Dehors",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.Terraforming,
    )
)

object ModuleRSE : Module(
    id = "secu_root",
    description = "mettre les images dans le bon scope",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
//        Enigme.SegmentRadioHorloge,
    )
)

object ModuleSecuGPT : Module(
    id = "secu_gpt",
    description = "Hacker un LLM",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
    )
)

// Scenario 2
//
object ModuleLumiereStation : Module(
    id = "lumiere_station",
    description = "Mettre la carte RFID sur le tableau de commande",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.InterrupteurGeneral,
    )
)

object ModuleSystemSolaire : Module(
    id = "systeme_solaire",
    description = "Ordonner les planètes grâces a la composition de l'atmosphère",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PorteSystemSolaire,
    )
)

object ModuleSeulSurMars : Module(
    id = "seul_sur_mars",
    description = "Trouver le code grâce au livre seul sur mars 1976",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PortePieceSeulSurMars,
    )
)

object ModuleSecuritePasswd : Module(
    id = "secu_password",
    description = "La porte s'ouvre au bout de 3 minutes, s'ils donnent le passwd, ils perdent",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.FishingPasswordTerminal,
    )
)

object ModuleHautsParleur : Module(
    id = "haut_parleur",
    description = "Un message est diffusé qui donne un code",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PorteHautParleur
    )
)

