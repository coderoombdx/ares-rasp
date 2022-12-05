package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.JeuMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StatutJeuMapperShould {
    @Test
    internal fun name() {
        val currentTimeInMillis = 1670256557L
        val jeu = JeuMock.default().copy(compteARebours = 10)

        val apiModel = jeu.toApiModel(currentTimeInMillis)

        // currentTimeInMillis exprimé en secondes + 10 minutes du compte à rebours
        assertEquals(1670256 + 10, apiModel.timestampFinDuJeu)
    }
}