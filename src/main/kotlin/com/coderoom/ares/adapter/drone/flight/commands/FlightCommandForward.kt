package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.DroneTelloRepository
import com.coderoom.ares.adapter.drone.flight.FlightCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FlightCommandForward(
    private val telloDriver: DroneTelloRepository.TelloDriver,
    private val delayInMillis: Long
) : FlightCommand {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        logger.info(javaClass.toString())
        Thread.sleep(delayInMillis)
    }
}