package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu

interface StoreRepository {

    fun getJeu(): Jeu

    fun getCompteARebours(): Int
    fun setCompteARebours(valeur: Int)

    fun setMessageAide(value: String?)
    fun getMessageAideTTL(): Int
    fun setMessageAideTTL(value: Int)

    fun incDerniereAlarme()
    fun resetDerniereAlarme()
}