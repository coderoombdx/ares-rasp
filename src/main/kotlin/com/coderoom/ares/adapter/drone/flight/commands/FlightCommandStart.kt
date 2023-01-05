package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver
import org.slf4j.LoggerFactory

class FlightCommandStart(
    private val telloDriver: TelloDriver
) : FlightCommand {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        logger.info("Execute")
        telloDriver.connect()
        if (telloDriver.isConnected) {
            logger.info("Connected")
            telloDriver.streamOn()
        }
    }
}