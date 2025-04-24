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
    description = "A l'extérieur de la station",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.CablePhotovoltaique,
        Enigme.PorteExterieur
    )
)

object ModuleHallEntree : Module(
    id = "hall_entree",
    description = "A13 Quest Airlock",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.SegmentHorlogeRadio,
    )
)

object ModuleSecuriteRoot : Module(
    id = "capcom_room",
    description = "A28 Mission control",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.FishingRootTerminal,
        Enigme.FishingRootDoor,
    )
)

object ModuleLevier : Module(
    id = "levier",
    description = "A35 Terraforming room",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.Levier,
    )
)

object ModuleTerraforming : Module(
    id = "terraforming",
    description = "A l'extérieur de la station",
    idScenario = ID_SCENARIO_1,
    enigmes = listOf(
        Enigme.Terraforming,
    )
)

// Scenario 2
//
object ModuleLumiereStation : Module(
    id = "lumiere_station",
    description = "B18",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.InterrupteurGeneral,
        Enigme.PorteExterieur,
    )
)

object ModuleSystemSolaire : Module(
    id = "systeme_solaire",
    description = "B19",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PorteSystemSolaire,
    )
)

object ModuleSeulSurMars : Module(
    id = "seul_sur_mars",
    description = "B22 Observatory",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PortePieceSeulSurMars,
    )
)

object ModuleSecuritePasswd : Module(
    id = "secu_password",
    description = "B48 Secondary mission control",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.FishingPasswordTerminal,
        Enigme.FishingPasswordDoor,
    )
)

object ModuleHautsParleur : Module(
    id = "haut_parleur",
    description = "B52 SETI telescope",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PorteHautParleur
    )
)

object ModuleTerraforming2 : Module(
    id = "terraforming",
    description = "B69 Terraforming room 2",
    idScenario = ID_SCENARIO_2,
    enigmes = listOf(
        Enigme.PorteHautParleur
    )
)
