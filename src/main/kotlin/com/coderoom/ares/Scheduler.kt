package com.coderoom.ares

import com.coderoom.ares.adapter.InMemoryStoreRepository
import com.coderoom.ares.adapter.tableauCommande.TableauCommandeArduinoRepository
import com.coderoom.ares.domain.service.ServiceCompterARebours
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class Scheduler(
    private val inMemoryStoreRepository: InMemoryStoreRepository,
    private val tableauCommandeArduinoRepository: TableauCommandeArduinoRepository,
    private val serviceCompterARebours: ServiceCompterARebours,
) {
    companion object {
        private const val oneSecond = 1000L
    }

    @Scheduled(fixedRate = oneSecond, initialDelay = 10 * oneSecond)
    private fun readAndStoreIncomingData() {
        serviceCompterARebours.manageCompteARebours()
        inMemoryStoreRepository.setTableauCommandeData(tableauCommandeArduinoRepository.readData())
    }
}


