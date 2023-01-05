package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import org.slf4j.LoggerFactory

class FlightCommandStop : FlightCommand {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        logger.info("Execute")
    }
}