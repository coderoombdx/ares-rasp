package com.coderoom.ares.adapter.drone.flight

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FlightCommandProcessor {
    private val queue = mutableListOf<FlightCommand>()

    fun addCommand(flightCommand: FlightCommand): FlightCommandProcessor = apply {
        queue.add(flightCommand)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun asyncProcessCommand(): FlightCommandProcessor = apply {
        GlobalScope.launch {
            queue.forEach { it.execute() }
            queue.clear()
        }
    }
}