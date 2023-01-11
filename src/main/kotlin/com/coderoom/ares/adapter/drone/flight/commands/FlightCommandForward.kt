package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver
import org.slf4j.LoggerFactory

class FlightCommandForward(
    private val telloDriver: TelloDriver,
    private val delayInMillis: Long
) : FlightCommand {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        logger.info("Execute")
        Thread.sleep(delayInMillis)
    }
}