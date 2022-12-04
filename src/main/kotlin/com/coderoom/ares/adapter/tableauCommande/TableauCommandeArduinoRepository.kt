package com.coderoom.ares.adapter.tableauCommande

import com.coderoom.ares.domain.model.TableauCommande
import org.springframework.stereotype.Repository

@Repository
class TableauCommandeArduinoRepository : TableauCommandeRepository {
    override fun readData(): TableauCommande {
        return TableauCommande(
            lumiereStationAllume = (0..1).random() == 0
        )
    }
}

