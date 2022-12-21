package com.coderoom.ares.adapter.drone

import com.coderoom.ares.adapter.drone.flight.FlightContext
import org.springframework.stereotype.Repository

@Repository
class DroneTelloRepository : DroneRepository {
    private val flightContext = FlightContext()

    override fun lanceVol(): Boolean {
        return if (TelloDriver.launched) {
            false
        } else {
            TelloDriver.launched = true
            true
        }

    }

    override fun relanceVol() {
        TelloDriver.launched = false
    }

    override fun vole() {
        if (TelloDriver.launched) flightContext.vol()
    }
}

private object TelloDriver {
    var launched = false
}

