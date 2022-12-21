package com.coderoom.ares.domain.service

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.adapter.store.InMemoryStoreRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ServiceGestionDuTempsShould {

    private val inMemoryStoreRepository = InMemoryStoreRepository()
    private val serviceCompterARebours = ServiceGestionDuTemps(inMemoryStoreRepository)

    @Nested
    @DisplayName("UpdateCompteARebours")
    inner class UpdateCompteARebours {

        @Test
        internal fun `decrease default number of second`() {
            inMemoryStoreRepository.setCompteARebours(10)

            serviceCompterARebours.updateCompteARebours()

            assertEquals(70, inMemoryStoreRepository.getCompteARebours())
        }

        @Test
        internal fun `decrease 5 second`() {
            inMemoryStoreRepository.setCompteARebours(10)

            serviceCompterARebours.updateCompteARebours(-5)

            assertEquals(5, inMemoryStoreRepository.getCompteARebours())
        }

        @Test
        internal fun `not decrease if not time remaining`() {
            inMemoryStoreRepository.setCompteARebours(5)

            serviceCompterARebours.updateCompteARebours(-10)

            assertEquals(0, inMemoryStoreRepository.getCompteARebours())
        }
    }

    @Nested
    @DisplayName("UpdateDerniereAlarme")
    inner class UpdateDerniereAlarme {
        @Test
        internal fun `augmente le temps depuis la derniere alarme`() {
            serviceCompterARebours.updateDerniereAlarme()

            assertEquals(1, inMemoryStoreRepository.getJeu().derniereAlarme)
        }
    }


    @Nested
    @DisplayName("ResetCompteARebours")
    inner class ResetCompteARebours {
        @Test
        internal fun `reset le compte a rebours`() {
            serviceCompterARebours.resetCompteARebours()

            assertEquals(TimeConstants.gameDuration, inMemoryStoreRepository.getJeu().compteARebours)
        }
    }

    @Nested
    @DisplayName("UpdateMessageAide")
    inner class UpdateMessageAide {

        @Test
        internal fun `decremente le TTL du message d'aide`() {
            inMemoryStoreRepository.setMessageAide("message")

            serviceCompterARebours.updateMessageAide()

            assertEquals(TimeConstants.messageTTL - 1, inMemoryStoreRepository.getMessageAideTTL())
            assertEquals("message", inMemoryStoreRepository.getJeu().messageAide)
        }

        @Test
        internal fun `reset le message d'aide lorsque le temps est a 0`() {
            inMemoryStoreRepository.setMessageAide("message")
            inMemoryStoreRepository.setMessageAideTTL(1)

            serviceCompterARebours.updateMessageAide()

            assertEquals(0, inMemoryStoreRepository.getMessageAideTTL())
            assertEquals(null, inMemoryStoreRepository.getJeu().messageAide)
        }
    }
}