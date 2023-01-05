package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver
import org.slf4j.LoggerFactory

class FlightCommandLanding(
    private val telloDriver: TelloDriver
) : FlightCommand {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        logger.info("Execute")
        if (telloDriver.isConnected) {
            with(telloDriver) {
                streamOff()
                land() //Use emergency() to stop immediately instead of landing
                disconnect()
            }
        }
    }
}