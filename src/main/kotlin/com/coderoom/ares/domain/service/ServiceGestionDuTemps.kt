package com.coderoom.ares.domain.service

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.adapter.store.InMemoryStoreRepository
import org.springframework.stereotype.Service

@Service
class ServiceGestionDuTemps(
    private val repository: InMemoryStoreRepository
) {

    companion object {
        private const val oneMinute = 60
        private const val oneSecond = 1
    }

    fun gereLeTemps() {
        updateCompteARebours(-oneSecond)
        updateMessageAide()
        updateDerniereAlarme()
    }

    fun updateCompteARebours(deltaInSecond: Int? = null) {
        val compteARebours = repository.getJeu().compteARebours + (deltaInSecond ?: oneMinute)

        if (compteARebours < 0) {
            repository.setCompteARebours(0)
        } else {
            repository.setCompteARebours(compteARebours)
        }
    }

    fun updateMessageAide() {
        val tempsRestant = repository.getMessageAideTTL() - oneSecond

        if (tempsRestant <= 0) {
            repository.setMessageAide(null)
        } else {
            repository.setMessageAideTTL(tempsRestant)
        }
    }

    fun updateDerniereAlarme() {
        repository.incDerniereAlarme()
    }

    fun resetCompteARebours() {
        repository.setCompteARebours(TimeConstants.dureeDuJeu)
        repository.resetDerniereAlarme()
        // TODO Reset des enigmes
    }

    fun resetAlarme() {
        repository.resetDerniereAlarme()
    }
}
