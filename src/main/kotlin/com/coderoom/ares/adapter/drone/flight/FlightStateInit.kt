package com.coderoom.ares.adapter.drone.flight

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object FlightStateInit : FlightState {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override val stateDelay = 0

    override fun vol(flightContext: FlightContext): FlightState {
        logger.info(javaClass.toString())
        return FlightStateTakeoff
    }
}