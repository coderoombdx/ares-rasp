package com.coderoom.ares.adapter.drone.flight

class FlightCommandProcessor {
    private val queue = mutableListOf<FlightCommand>()

    fun addCommand(flightCommand: FlightCommand): FlightCommandProcessor = apply {
        queue.add(flightCommand)
    }

    fun processCommand(): FlightCommandProcessor = apply {
        queue.forEach { it.execute() }
        queue.clear()
    }
}