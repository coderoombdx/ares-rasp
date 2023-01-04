package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.DroneTelloRepository
import com.coderoom.ares.adapter.drone.flight.FlightCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FlightCommandStop(
    private val telloDriver: DroneTelloRepository.TelloDriver
) : FlightCommand {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        telloDriver.launched = false
        logger.info(javaClass.toString())
    }
}