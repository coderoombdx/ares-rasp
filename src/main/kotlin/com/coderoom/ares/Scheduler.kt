package com.coderoom.ares

import com.coderoom.ares.domain.service.ServiceGestionDuTemps
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class Scheduler(
    private val serviceGestionDuTemps: ServiceGestionDuTemps,
) {
    @Scheduled(fixedRate = TimeConstants.millisPerSecond, initialDelay = 10 * TimeConstants.millisPerSecond)
    private fun readAndStoreIncomingData() {
        serviceGestionDuTemps.gereLeTemps()
    }
}


