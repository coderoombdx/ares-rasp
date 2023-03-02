package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.domain.model.Jeu
import org.springframework.stereotype.Repository

@Repository
class InMemoryStoreRepository : StoreRepository {
    override fun getJeu() = Jeu(
        compteARebours = StoreSingleton.compteARebours,
        messageAide = StoreSingleton.messageAide,
        derniereAlarme = StoreSingleton.derniereAlarme,
        modules = listOf(),
    )

    override fun setCompteARebours(valeur: Int) {
        StoreSingleton.compteARebours = valeur
    }

    override fun getCompteARebours(): Int {
        return StoreSingleton.compteARebours
    }

    override fun setMessageAide(value: String?) {
        StoreSingleton.messageAide = value
        if (value == null) {
            StoreSingleton.messageAideTTL = 0
        } else {
            StoreSingleton.messageAideTTL = TimeConstants.messageTTL
        }
    }

    override fun incDerniereAlarme() {
        StoreSingleton.derniereAlarme++
    }

    override fun resetDerniereAlarme() {
        StoreSingleton.derniereAlarme = 0
    }

    override fun getMessageAideTTL(): Int {
        return StoreSingleton.messageAideTTL
    }

    override fun setMessageAideTTL(value: Int) {
        StoreSingleton.messageAideTTL = value
    }
}

private object StoreSingleton {
    var compteARebours: Int = TimeConstants.gameDuration
    var messageAide: String? = null
    var messageAideTTL: Int = 0
    var derniereAlarme: Int = 0
}
