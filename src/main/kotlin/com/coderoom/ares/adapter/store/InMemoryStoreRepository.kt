package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.domain.model.OnOff
import com.coderoom.ares.domain.model.OnOff.Off
import com.coderoom.ares.domain.model.OnOff.On
import com.coderoom.ares.domain.model.OuvertFerme
import com.coderoom.ares.domain.model.OuvertFerme.Ferme
import com.coderoom.ares.domain.model.Scenario1
import com.coderoom.ares.domain.model.Scenario2
import com.coderoom.ares.domain.model.TableauCommande
import org.springframework.stereotype.Repository

@Repository
class InMemoryStoreRepository : StoreRepository {
    override fun getJeu() = Jeu(
        compteARebours = StoreSingleton.compteARebours,
        messageAide = StoreSingleton.messageAide,
        electriciteGenerale = StoreSingleton.electriciteGenerale,
        derniereAlarme = StoreSingleton.derniereAlarme,
        scenario1 = Scenario1(
            porte1 = StoreSingleton.scenario1.porte1
        ),
        scenario2 = Scenario2(
            porte1 = StoreSingleton.scenario2.porte1
        )
    )

    override fun setCompteARebours(valeur: Int) {
        StoreSingleton.compteARebours = valeur
    }

    override fun getCompteARebours(): Int {
        return StoreSingleton.compteARebours
    }

    override fun setTableauCommandeData(statutTableauCommande: TableauCommande) {
        StoreSingleton.electriciteGenerale = if (statutTableauCommande.lumiereStationAllume) On else Off
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
    var electriciteGenerale: OnOff = Off
    var derniereAlarme: Int = 0
    val scenario1: StoreScenario1 = StoreScenario1
    val scenario2: StoreScenario2 = StoreScenario2
}

private object StoreScenario1 {
    var porte1: OuvertFerme = Ferme
}

private object StoreScenario2 {
    var porte1: OuvertFerme = Ferme
}
