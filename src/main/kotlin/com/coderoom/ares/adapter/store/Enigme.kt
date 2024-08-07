package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.domain.model.Jeu

sealed class Enigme(
    val id: String,
    val description: String,
    var resolu: Boolean,
    val code: (Jeu) -> String?,
) {
    companion object {
        const val ID_CABLE_PHOTOVOLTAIQUE = "cable"
        const val ID_INTER_GENERAL = "inter_general"
        const val ID_PORTE_EXTERIEUR = "porte_exterieure"
        const val ID_SEGMENT_HORLOGE_RADIO = "segment_horloge"
        const val LEVIER = "levier"
        const val ID_FISHING_PASSWORD_TERMINAL = "fishing_password_terminal"
        const val ID_FISHING_PASSWORD_DOOR_START = "fishing_password_door_start"
        const val ID_FISHING_PASSWORD_DOOR_OPEN = "fishing_password_door_open"
        const val ID_FISHING_ROOT_TERMINAL = "fishing_root_terminal"
        const val ID_FISHING_ROOT_DOOR_START = "fishing_root_door_open"
        const val ID_FISHING_ROOT_DOOR_OPEN = "fishing_root_door_open"
        const val ID_SYSTEME_SOLAIRE = "systeme_solaire"
        const val ID_SEUL_SUR_MARS = "seul_sur_mars"
        const val ID_HAUT_PARLEUR = "haut_parleur"
    }

    object CablePhotovoltaique : Enigme(
        id = ID_CABLE_PHOTOVOLTAIQUE,
        description = "Relier le cable des panneaux photovoltaiques sur mars (branche)",
        resolu = false,
        code = { _ -> "branche" },
    )

    object InterrupteurGeneral : Enigme(
        id = ID_INTER_GENERAL,
        description = "Allumer l'interrupteur générale pour eclairer la station RFID Arduino (allume)",
        resolu = false,
        code = { _ -> "resulu" },
    )

    object PorteExterieur : Enigme(
        id = ID_PORTE_EXTERIEUR,
        description = "Aligner les satellites (phobos)",
        resolu = false,
        code = { jeu ->
            if (jeu.getEnigme(ID_CABLE_PHOTOVOLTAIQUE)?.resolu == false) {
                null
            } else {
                "phobos"
            }
        }
    )

    object SegmentHorlogeRadio : Enigme(
        id = ID_SEGMENT_HORLOGE_RADIO,
        description = "Compter le nombre de segments du radio réveil (4 chiffres)",
        resolu = false,
        code = { jeu ->

            val secondesRestantes = jeu.heureMartienneEnSecondes.toLong()
            val heuresRestantes = secondesRestantes / 3600
            val minutesRestantes = (secondesRestantes % 3600) / 60

            String.format("%02d:%02d", heuresRestantes, minutesRestantes)
                .toList()
                .joinToString(separator = "") {
                    when (it) {
                        '1' -> "2"
                        '2', '3', '5' -> "5"
                        '4' -> "4"
                        '0', '6', '9' -> "6"
                        '7' -> "3"
                        '8' -> "7"
                        else -> ""
                    }
                }
        }
    )

    object PorteSystemSolaire : Enigme(
        id = ID_SYSTEME_SOLAIRE,
        description = "Tape le 32675 pour sortir de la piece (32675)",
        resolu = false,
        code = { _ -> "32675" }
    )

    object FishingRootTerminalRoot : Enigme(
        id = ID_FISHING_ROOT_TERMINAL,
        description = "Si les joueurs saisissent le user admin, ils ont perdu (Admin-ares)",
        resolu = false,
        code = { _ -> "Admin-ares" }
    )

    object FishingRootDoorStart : Enigme(
        id = ID_FISHING_ROOT_DOOR_START,
        description = "Enigme technique : quand le joueur entre dans la piece, cela déclenche un chrono",
        resolu = false,
        code = { jeu ->
            jeu.fishingDoorStart = jeu.compteARebours + TimeConstants.delaiOuverturePorteCapCom
            "declenche"
        }
    )

    object FishingRootDoorOpen : Enigme(
        id = ID_FISHING_ROOT_DOOR_OPEN,
        description = "Enigme technique : après un temps donné, la porte s'ouvre ()",
        resolu = false,
        code = { _ ->
            ""
        }
    )

    object FishingPasswordTerminal : Enigme(
        id = ID_FISHING_PASSWORD_TERMINAL,
        description = "Si les joueurs saisissent le password, ils ont perdu (A&oYGrpkD#99mqZ)",
        resolu = false,
        code = { _ -> "A&oYGrpkD#99mqZ" }
    )

    object FishingPasswordDoorStart : Enigme(
        id = ID_FISHING_PASSWORD_DOOR_START,
        description = "Enigme technique : quand le joueur entre dans la piece, cela déclenche un chrono",
        resolu = false,
        code = { jeu ->
            jeu.fishingDoorStart = jeu.compteARebours + TimeConstants.delaiOuverturePorteCapCom
            "declenche"
        }
    )

    object FishingPasswordDoorOpen : Enigme(
        id = ID_FISHING_PASSWORD_DOOR_OPEN,
        description = "Enigme technique : après un temps donné, la porte s'ouvre ()",
        resolu = false,
        code = { jeu ->
            jeu.fishingDoorStart = jeu.compteARebours + TimeConstants.delaiOuverturePorteCapCom
            "declenche"
        }
    )

    object Levier : Enigme(
        id = LEVIER,
        description = "Les deux joueurs doivent abaisser un levier pour terraformer Mars",
        resolu = false,
        code = { jeu ->
            jeu.fishingDoorStart = jeu.compteARebours + TimeConstants.delaiOuverturePorteCapCom
            "declenche"
        }
    )

    object Terraforming : Enigme(
        id = "terraforming",
        description = "Lancer la terraformation",
        resolu = false,
        code = { jeu ->
            jeu.terraformation = true
            ""
        }
    )

    object PortePieceSeulSurMars : Enigme(
        id = ID_SEUL_SUR_MARS,
        description = "Trouver le code P314, L5, M3 (1976)",
        resolu = false,
        code = { _ -> "1976" }
    )

    object PorteHautParleur : Enigme(
        id = ID_HAUT_PARLEUR,
        description = "Trouver le mot sur les hauts parleurs (oxygene)",
        resolu = false,
        code = { _ -> "oxygene" }
    )
}