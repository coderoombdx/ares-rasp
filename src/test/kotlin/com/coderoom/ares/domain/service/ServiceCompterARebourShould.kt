package com.coderoom.ares.domain.service

import com.coderoom.ares.adapter.StoreSingleton
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ServiceCompterARebourShould {

    private val serviceCompterARebour=ServiceCompterARebours()

    @Test
    internal fun `decrease 1 second`() {
        StoreSingleton.compteARebours=10

        serviceCompterARebour.manageCompteARebours()

        assertEquals(9, StoreSingleton.compteARebours)
    }

    @Test
    internal fun `not decrease if not time remaining`() {
        StoreSingleton.compteARebours=0

        serviceCompterARebour.manageCompteARebours()

        assertEquals(0, StoreSingleton.compteARebours)
    }
}