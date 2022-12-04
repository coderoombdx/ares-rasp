package com.coderoom.ares.adapter.store

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.domain.model.TableauCommande

interface StoreRepository {

    fun getEtatJeu() : Jeu
    fun manageCompteARebours()
    fun setTableauCommandeData(statutTableauCommande: TableauCommande)
}