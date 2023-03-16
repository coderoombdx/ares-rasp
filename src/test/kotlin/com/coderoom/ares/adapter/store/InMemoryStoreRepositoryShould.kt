package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class InMemoryStoreRepositoryShould {
    @Test
    internal fun `get jeu`() {
        val inMemoryStoreRepository = InMemoryStoreRepository()

        val jeu = inMemoryStoreRepository.getJeu()

        assertEquals(2700, jeu.compteARebours)
        assertEquals(null, jeu.messageAide)
        assertEquals(0, jeu.derniereAlarme)
        val moduleExterieur = jeu.modules.firstOrNull { it.id == "exterieur" }
        assertEquals("Module extérieur", moduleExterieur?.description)

        val enigme = moduleExterieur?.enigmes?.firstOrNull { it.id == "cable" }
        assertNotNull(enigme)
    }

    @Test
    internal fun `get et sed compteARebours`() {
        val inMemoryStoreRepository = InMemoryStoreRepository()

        inMemoryStoreRepository.setCompteARebours(512)
        val compteARebours = inMemoryStoreRepository.getJeu().compteARebours

        assertEquals(512, compteARebours)
    }

    @Nested
    @DisplayName("messsageAide")
    inner class MessageAide {
        @Test
        internal fun `return message and TTLMessage`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            inMemoryStoreRepository.setMessageAide("message")
            val messageAideTTL = inMemoryStoreRepository.getMessageAideTTL()
            val jeu = inMemoryStoreRepository.getJeu()

            assertEquals("message", jeu.messageAide)
            assertEquals(TimeConstants.messageTTL, messageAideTTL)
        }

        @Test
        internal fun `return 0 with null message`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            inMemoryStoreRepository.setMessageAide(null)
            val messageAideTTL = inMemoryStoreRepository.getMessageAideTTL()
            val jeu = inMemoryStoreRepository.getJeu()

            assertEquals(null, jeu.messageAide)
            assertEquals(0, messageAideTTL)
        }
    }

    @Nested
    @DisplayName("setEngime")
    inner class SetEnigme {
        @Test
        internal fun `return not found`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            val enigmeResult = inMemoryStoreRepository.setEnigme("dummy", "code")

            assertEquals(ResoudreEnigmeResult.NotFound, enigmeResult)
        }

        @Test
        internal fun `return ok with unresolved predecessor`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            val enigmeResult = inMemoryStoreRepository.setEnigme(Enigme.CablePhotovoltaique.id, "code")

            assertEquals(ResoudreEnigmeResult.Failure("branche"), enigmeResult)
        }

        @Test
        internal fun `return ok with correct sucret code`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            inMemoryStoreRepository.setEnigme(Enigme.CablePhotovoltaique.id, "branche")

            val enigmeResult = inMemoryStoreRepository.setEnigme(Enigme.CablePhotovoltaique.id, "branche")

            assertEquals(ResoudreEnigmeResult.Success, enigmeResult)
        }

        @Test
        internal fun `return failure with correct sucret code`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            val enigmeResult = inMemoryStoreRepository.setEnigme(Enigme.PortePiece1.id, "incorrect")

            assertEquals(ResoudreEnigmeResult.Failure("1024"), enigmeResult)
        }
    }

    @Nested
    @DisplayName("ResetEngime")
    inner class ResetEnigme {
        @Test
        internal fun `return not found`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            val enigmeResult = inMemoryStoreRepository.resetEnigme("dummy")

            assertEquals(ResetEnigmeResult.NotFound, enigmeResult)
        }

        @Test
        internal fun `return ok`() {
            val inMemoryStoreRepository = InMemoryStoreRepository()

            val enigmeResult = inMemoryStoreRepository.resetEnigme("porte_exterieure")

            assertEquals(ResetEnigmeResult.Success, enigmeResult)
        }
    }
}

