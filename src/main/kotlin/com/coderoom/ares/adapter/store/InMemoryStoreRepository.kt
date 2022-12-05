package com.coderoom.ares.adapter.store

import com.coderoom.ares.TimeConstants
import com.coderoom.ares.domain.model.OnOff
import com.coderoom.ares.domain.model.OnOff.Off
import com.coderoom.ares.domain.model.OnOff.On
import com.coderoom.ares.domain.model.OuvertFerme
import com.coderoom.ares.domain.model.OuvertFerme.Ferme
import com.coderoom.ares.domain.model.TableauCommande
import org.springframework.stereotype.Repository

@Repository
class InMemoryStoreRepository : StoreRepository {
    override fun getJeu() = StoreSingleton.toJeu()

    override fun manageCompteARebours() {
        StoreSingleton.compteARebours--
    }

    override fun setTableauCommandeData(statutTableauCommande: TableauCommande) {
        StoreSingleton.electriciteGenerale = if (statutTableauCommande.lumiereStationAllume) On else Off
    }

}

object StoreSingleton {
    var compteARebours: Int = TimeConstants.gameDuration
    var dernierMessage: String = ""
    var electriciteGenerale: OnOff = Off
    var derniereAlarme: Int = 0
    val scenario1: StoreScenario1 = StoreScenario1
    val scenario2: StoreScenario2 = StoreScenario2
}

object StoreScenario1 {
    var porte1: OuvertFerme = Ferme
}

object StoreScenario2 {
    var porte1: OuvertFerme = Ferme
}
