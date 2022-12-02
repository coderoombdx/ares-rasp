package com.coderoom.ares

import com.coderoom.ares.repository.StatusSingleton
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class Scheduler {
    @Scheduled(fixedRate = 1000, initialDelay = 10000)
    fun readAndStoreElectricPowerData() {
        StatusSingleton.data++
    }
}

