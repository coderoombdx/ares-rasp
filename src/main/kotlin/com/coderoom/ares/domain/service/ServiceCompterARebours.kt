package com.coderoom.ares.domain.service

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.adapter.store.StoreSingleton
import org.springframework.stereotype.Service

@Service
class ServiceCompterARebours {

    companion object {
        private const val oneSecond = 1
    }

    fun manageTime() {
        updateCompteARebours(-1)
        updateDerniereAlarme()
    }

    fun updateCompteARebours(deltaInSecond: Int? = null) {
        val compteARebours = StoreSingleton.compteARebours + (deltaInSecond ?: -oneSecond)

        if (compteARebours < 0) {
            StoreSingleton.compteARebours = 0
        } else {
            StoreSingleton.compteARebours = compteARebours
        }
    }

    fun updateDerniereAlarme() {
        StoreSingleton.derniereAlarme++
    }

    fun resetCompteARebours() {
        StoreSingleton.compteARebours = TimeConstants.gameDuration
    }
}