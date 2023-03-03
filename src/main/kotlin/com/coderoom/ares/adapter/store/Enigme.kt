package com.coderoom.ares.adapter.store

sealed class Enigme(
    val id: String,
    val description: String,
    var resolu: Boolean,
    var code: String?
) {
    object CablePhotovoltaique : Enigme(
        id = "cable",
        description = "Relier le cable des panneaux photovoltaiques",
        resolu = false,
        code = null
    )

    object InterrupteurGeneral : Enigme(
        id = "inter_general",
        description = "Allumer l'interrupteur générale pour eclairer la station",
        resolu = true,
        code = null
    )

    object PorteExterieur : Enigme(
        id = "porte_exterieur",
        description = "Tape un code pour entrer dans la station",
        resolu = true,
        code = "1024"
    )

    object PortePiece1 : Enigme(
        id = "porte_piece1",
        description = "Tape un code pour sortir de la piece",
        resolu = true,
        code = null
    )

    object PortePiece2 : Enigme(
        id = "porte_piece1",
        description = "Tape un code pour sortir de la piece",
        resolu = false,
        code = null
    )
}