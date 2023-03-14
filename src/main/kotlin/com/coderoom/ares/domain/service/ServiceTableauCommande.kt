package com.coderoom.ares.domain.service

import com.coderoom.ares.adapter.store.Enigme
import com.coderoom.ares.adapter.store.InMemoryStoreRepository
import com.coderoom.ares.adapter.tableauCommande.TableauCommandeArduinoRepository
import org.springframework.stereotype.Service

@Service
class ServiceTableauCommande(
    private val tableauCommandeRepository: TableauCommandeArduinoRepository,
    private val storeRepository: InMemoryStoreRepository
) {
    fun setInterGeneral() {
        tableauCommandeRepository.readData()
        storeRepository.setEnigme(Enigme.InterrupteurGeneral.id, "branche")
    }
}