package com.coderoom.ares.adapter.drone

import com.coderoom.ares.adapter.drone.flight.FlightCommandProcessor
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandForward
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandLanding
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandStop
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandTakeoff
import org.springframework.stereotype.Repository


@Repository
class DroneTelloRepository : DroneRepository {
    override fun lanceVol(): Boolean {
        return if (TelloDriver.launched) {
            false
        } else {
            TelloDriver.launched = true
            FlightCommandProcessor()
                .addCommand(FlightCommandTakeoff(2000L))
                .addCommand(FlightCommandForward(2000L))
                .addCommand(FlightCommandLanding(2000L))
                .addCommand(FlightCommandStop())
                .processCommand()
            true
        }
    }

    override fun relanceVol() {
        TelloDriver.launched = false
    }

    private object TelloDriver {
        var launched = false
    }
}

