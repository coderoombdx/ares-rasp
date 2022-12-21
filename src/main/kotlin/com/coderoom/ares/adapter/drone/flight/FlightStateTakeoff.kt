package com.coderoom.ares.adapter.drone.flight

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object FlightStateTakeoff : FlightState {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override val stateDelay = 3

    override fun vol(flightContext: FlightContext): FlightState {
        logger.info(javaClass.toString())
        // Envoie l'ordre de décollage
        return FlightStateForward
    }
}