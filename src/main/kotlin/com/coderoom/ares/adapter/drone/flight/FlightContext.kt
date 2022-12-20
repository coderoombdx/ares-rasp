package com.coderoom.ares.adapter.drone.flight

class FlightContext {
    private var currentState: FlightState = FlightStateInit
    private var currentFlightDuration = 0
    private var nextFlightDuration = 0

    fun vol() {
        this.currentFlightDuration++
        if (this.currentFlightDuration >= this.nextFlightDuration) {
            this.currentState = this.currentState.vol(this)
            this.nextFlightDuration += this.currentState.stateDelay
        }
    }
}