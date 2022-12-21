package com.coderoom.ares.adapter.drone.flight

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object FlightStateStop : FlightState {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override val stateDelay = 60

    override fun vol(flightContext: FlightContext): FlightState {
        logger.info(javaClass.toString())
        // Envoie l'ordre d'atterissage
        return FlightStateStop
    }
}