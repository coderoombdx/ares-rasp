package com.coderoom.ares.adapter.drone.flight

interface FlightState {
    val stateDelay: Int

    fun vol(flightContext: FlightContext): FlightState
}