package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu

sealed class Enigme(
    val id: String,
    val description: String,
    var resolu: Boolean,
    val code: (Jeu) -> String?,
) {
    companion object {
        private const val ID_CABLE_PHOTOVOLTAIQUE = "cable"
        private const val ID_INTER_GENERAL = "inter_general"
        private const val ID_PORTE_EXTERIEUR = "porte_exterieure"
        private const val ID_PORTE_PIECE1 = "porte_piece1"
        private const val ID_PORTE_PIECE2 = "porte_piece2"
        private const val ID_SEUL_SUR_MARS = "seul_sur_mars"
    }

    object CablePhotovoltaique : Enigme(
        id = ID_CABLE_PHOTOVOLTAIQUE,
        description = "Relier le cable des panneaux photovoltaiques",
        resolu = false,
        code = { _ -> "branche" },
    )

    object InterrupteurGeneral : Enigme(
        id = ID_INTER_GENERAL,
        description = "Allumer l'interrupteur générale pour eclairer la station",
        resolu = false,
        code = { _ -> "allume" },
    )

    object PorteExterieur : Enigme(
        id = ID_PORTE_EXTERIEUR,
        description = "Alignement des satellites donne le code",
        resolu = false,
        code = { jeu ->
            if (jeu.getEnigme(ID_CABLE_PHOTOVOLTAIQUE)?.resolu == false) {
                null
            } else {
                "phobos"
            }
        }
    )

    object PortePiece1 : Enigme(
        id = ID_PORTE_PIECE1,
        description = "Tape un code pour sortir de la piece",
        resolu = false,
        code = { _ -> "1024" }
    )

    object SegmentRadioHorloge : Enigme(
        id = ID_PORTE_PIECE2,
        description = "Compter le nombre de segments correspondant au temps restant",
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

    object PortePieceSeulSurMars : Enigme(
        id = ID_SEUL_SUR_MARS,
        description = "Trouver le code P314, L5, M3",
        resolu = false,
        code = { _ -> "1976" }
    )


}