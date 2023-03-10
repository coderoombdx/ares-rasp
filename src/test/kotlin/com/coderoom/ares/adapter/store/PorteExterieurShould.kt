package com.coderoom.ares.adapter.store

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PorteExterieurShould {

    @Test
    fun `la porte ne s'ouvre pas si le cable photovoltaique n'est pas branché`() {
        val storeRepository = InMemoryStoreRepository()
        val jeu = storeRepository.getJeu()
        jeu.getEnigme(Enigme.CablePhotovoltaique.id)?.resolu = true

        assertEquals("phobos", Enigme.PorteExterieur.code(jeu))
    }

    @Test
    fun `la porte retourne un code si si le cable photovoltaique est branché`() {
        val storeRepository = InMemoryStoreRepository()
        val jeu = storeRepository.getJeu()
        jeu.getEnigme(Enigme.CablePhotovoltaique.id)?.resolu = false

        assertEquals(null, Enigme.PorteExterieur.code(jeu))
    }
}