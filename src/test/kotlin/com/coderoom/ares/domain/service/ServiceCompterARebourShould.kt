package com.coderoom.ares.domain.service

import com.coderoom.ares.adapter.store.StoreSingleton
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ServiceCompterARebourShould {

    private val serviceCompterARebour = ServiceCompterARebours()

    @Nested
    @DisplayName("ManageTime")
    inner class ManageTime {
        @Test
        internal fun `not decrease if not time remaining`() {
            StoreSingleton.compteARebours = 10
            StoreSingleton.derniereAlarme = 0

            serviceCompterARebour.manageTime()

            assertEquals(9, StoreSingleton.compteARebours)
            assertEquals(1, StoreSingleton.derniereAlarme)
        }
    }

    @Nested
    @DisplayName("UpdateCompteARebours")
    inner class UpdateCompteARebours {

        @Test
        internal fun `decrease default number of second`() {
            StoreSingleton.compteARebours = 10

            serviceCompterARebour.updateCompteARebours()

            assertEquals(9, StoreSingleton.compteARebours)
        }

        @Test
        internal fun `decrease 5 second`() {
            StoreSingleton.compteARebours = 10

            serviceCompterARebour.updateCompteARebours(-5)

            assertEquals(5, StoreSingleton.compteARebours)
        }

        @Test
        internal fun `not decrease if not time remaining`() {
            StoreSingleton.compteARebours = 5

            serviceCompterARebour.updateCompteARebours(-10)

            assertEquals(0, StoreSingleton.compteARebours)
        }
    }

    @Nested
    @DisplayName("UpdateDerniereAlarme")
    inner class UpdateDerniereAlarme {
        @Test
        internal fun `not decrease if not time remaining`() {
            StoreSingleton.derniereAlarme = 5

            serviceCompterARebour.updateDerniereAlarme()

            assertEquals(6, StoreSingleton.derniereAlarme)
        }
    }


    @Nested
    @DisplayName("ResetCompteARebours")
    inner class ResetCompteARebours {
        @Test
        internal fun `not decrease if not time remaining`() {
            serviceCompterARebour.resetCompteARebours()

            assertEquals(6, StoreSingleton.derniereAlarme)
        }
    }
}