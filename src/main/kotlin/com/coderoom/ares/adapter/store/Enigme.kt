package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu

sealed class Enigme(
    val id: String,
    val description: String,
    var resolu: Boolean,
    var code: (Jeu) -> String?
) {
    object CablePhotovoltaique : Enigme(
        id = "cable",
        description = "Relier le cable des panneaux photovoltaiques",
        resolu = false,
        code = { _ -> null }
    )

    object InterrupteurGeneral : Enigme(
        id = "inter_general",
        description = "Allumer l'interrupteur générale pour eclairer la station",
        resolu = true,
        code = { _ -> null }
    )

    object PorteExterieur : Enigme(
        id = "porte_exterieur",
        description = "Tape un code pour entrer dans la station",
        resolu = true,
        code = { _ -> "1024" }
    )

    object PortePiece1 : Enigme(
        id = "porte_piece1",
        description = "Tape un code pour sortir de la piece",
        resolu = true,
        code = { _ -> null }
    )

    object PortePiece2 : Enigme(
        id = "porte_piece1",
        description = "Tape un code pour sortir de la piece",
        resolu = false,
        code = { jeu ->

            val secondesRestantes = jeu.compteARebours.toLong()
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
}