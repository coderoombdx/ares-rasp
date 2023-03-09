package com.coderoom.ares.domain.model


internal class EnigmeMock {
    companion object {
        fun cable() = Enigme(
            id = "cable",
            description = "Relier le cable des panneaux photovoltaïques",
            resolu = false,
            code = { null }
        )

        fun interGeneral() = Enigme(
            id = "inter_general",
            description = "Allumer l'interrupteur générale pour éclairer la station",
            resolu = true,
            code = { null }
        )

        fun sortiePiece1() = Enigme(
            id = "sortie_piece1",
            description = "Tape un code pour sortir de la piece",
            resolu = true,
            code = { null }
        )

        fun sortiePiece2() = Enigme(
            id = "sortie_piece2",
            description = "Tape un code pour sortir de la piece",
            resolu = false,
            code = { null }
        )
    }
}