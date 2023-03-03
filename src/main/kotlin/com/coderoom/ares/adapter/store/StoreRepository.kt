package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu

interface StoreRepository {

    fun getJeu(): Jeu

    fun setCompteARebours(valeur: Int)

    fun setMessageAide(value: String?)
    fun getMessageAideTTL(): Int
    fun setMessageAideTTL(value: Int)

    fun incDerniereAlarme()
    fun resetDerniereAlarme()

    fun setEnigme(id: String, solution: String?): EnigmeResult
    fun resetEnigme(id: String): EnigmeResult
}

sealed interface EnigmeResult {
    object Success : EnigmeResult
    object NotFound : EnigmeResult
    object Failure : EnigmeResult
}