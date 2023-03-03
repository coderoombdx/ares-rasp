package com.coderoom.ares.domain.model


internal class ModuleMock {
    companion object {
        fun exterieur() = Module(
            id = "exterieur",
            enigmes = listOf(
                EnigmeMock.cable(),
                EnigmeMock.interGeneral()
            )
        )

        fun interieur1() = Module(
            id = "interieur1",
            enigmes = listOf(
                EnigmeMock.sortiePiece1()
            )
        )

        fun interieur2() =
            Module(
                id = "interieur2",
                enigmes = listOf(
                    EnigmeMock.sortiePiece2()
                )
            )
    }
}