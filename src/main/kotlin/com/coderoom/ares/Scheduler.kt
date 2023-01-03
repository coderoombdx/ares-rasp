package com.coderoom.ares

import com.coderoom.ares.adapter.drone.DroneRepository
import com.coderoom.ares.adapter.store.InMemoryStoreRepository
import com.coderoom.ares.adapter.tableauCommande.TableauCommandeArduinoRepository
import com.coderoom.ares.domain.service.ServiceGestionDuTemps
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class Scheduler(
    private val inMemoryStoreRepository: InMemoryStoreRepository,
    private val tableauCommandeArduinoRepository: TableauCommandeArduinoRepository,
    private val serviceGestionDuTemps: ServiceGestionDuTemps,
    private val droneRepository: DroneRepository
) {
    @Scheduled(fixedRate = TimeConstants.millisPerSecond, initialDelay = 10 * TimeConstants.millisPerSecond)
    private fun readAndStoreIncomingData() {
        serviceGestionDuTemps.gereLeTemps()
        inMemoryStoreRepository.setTableauCommandeData(tableauCommandeArduinoRepository.readData())
    }
}


