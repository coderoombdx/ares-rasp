package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.domain.model.Enigme
import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.domain.model.Module
import org.springframework.stereotype.Repository

@Repository
class InMemoryStoreRepository : StoreRepository {
    override fun getJeu() = Jeu(
        compteARebours = StoreSingleton.compteARebours,
        messageAide = StoreSingleton.messageAide,
        derniereAlarme = StoreSingleton.derniereAlarme,
        modules = StoreSingleton.modules.map { module ->
            Module(
                module.id,
                module.enigmes.map { enigme ->
                    Enigme(
                        id = enigme.id,
                        description = enigme.description,
                        resolu = enigme.resolu,
                        code = enigme.code
                    )
                }
            )
        },
    )

    override fun setCompteARebours(valeur: Int) {
        StoreSingleton.compteARebours = valeur
    }

    override fun setMessageAide(value: String?) {
        StoreSingleton.messageAide = value
        if (value == null) {
            StoreSingleton.messageAideTTL = 0
        } else {
            StoreSingleton.messageAideTTL = TimeConstants.messageTTL
        }
    }

    override fun getMessageAideTTL(): Int {
        return StoreSingleton.messageAideTTL
    }

    override fun setMessageAideTTL(value: Int) {
        StoreSingleton.messageAideTTL = value
    }

    override fun incDerniereAlarme() {
        StoreSingleton.derniereAlarme++
    }

    override fun resetDerniereAlarme() {
        StoreSingleton.derniereAlarme = 0
    }

    override fun setEnigme(id: String, solution: String?): EnigmeResult {
        val enigme = getEnigme(id)
        return if (enigme == null) {
            EnigmeResult.NotFound
        } else {
            if (enigme.code == solution) {
                enigme.resolu = true
                EnigmeResult.Success
            } else {
                EnigmeResult.Failure
            }
        }
    }

    override fun resetEnigme(id: String): EnigmeResult {
        val enigme = getEnigme(id)
        return if (enigme == null) {
            EnigmeResult.NotFound
        } else {
            enigme.resolu = false
            EnigmeResult.Success
        }
    }

    private fun getEnigme(id: String) = StoreSingleton.modules.map { it.enigmes }.flatten().firstOrNull { it.id == id }

}

private object StoreSingleton {
    var compteARebours: Int = TimeConstants.gameDuration
    var messageAide: String? = null
    var messageAideTTL: Int = 0
    var derniereAlarme: Int = 0
    val modules = listOf(
        ModuleInterieur1,
        ModuleExterieur,
        ModuleInterieur2
    )
}
