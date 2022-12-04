package com.coderoom.ares.adapter

import com.coderoom.ares.adapter.store.StoreRepository
import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.domain.model.Station
import com.coderoom.ares.domain.model.TableauCommande
import org.springframework.stereotype.Repository

@Repository
class InMemoryStoreRepository : StoreRepository {
    override fun getEtatJeu() = StoreSingleton.toEtatJeu()

    override fun manageCompteARebours() {
        StoreSingleton.compteARebours--
    }

    override fun setTableauCommandeData(statutTableauCommande: TableauCommande) {
        StoreSingleton.storeStation.lumiereGeneraleAllumee = statutTableauCommande.lumiereStationAllume
    }

}

internal fun StoreSingleton.toEtatJeu() = Jeu(
    compteARebours = this.compteARebours,
    station = Station(
        lumiereGeneraleAllumee = this.storeStation.lumiereGeneraleAllumee,
    ),
)

private const val minutesPerHour = 60
private const val secondsPerMinute = 60
private const val onSecond = 1000

object StoreSingleton {
    var compteARebours = 45 * minutesPerHour * secondsPerMinute * onSecond
    val storeStation = StoreStation
}

object StoreStation {
    var lumiereGeneraleAllumee: Boolean = false
}