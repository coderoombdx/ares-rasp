package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu

interface StoreRepository {

    fun getJeu(): Jeu

    fun setCompteARebours(valeur: Int)
    fun setInterrupteurGeneral(enMarche: Boolean)

    fun setMessageAide(value: String?)
    fun getMessageAideTTL(): Int
    fun setMessageAideTTL(value: Int)

    fun incDerniereAlarme()
    fun resetDerniereAlarme()

    fun setEnigme(id: String, solution: String): ResoudreEnigmeResult
    fun resetEnigme(id: String): ResetEnigmeResult
}

sealed interface ResoudreEnigmeResult {
    object Success : ResoudreEnigmeResult
    object NotFound : ResoudreEnigmeResult
    data class Failure(val solution: String) : ResoudreEnigmeResult
}

sealed interface ResetEnigmeResult {
    object Success : ResetEnigmeResult
    object NotFound : ResetEnigmeResult
}