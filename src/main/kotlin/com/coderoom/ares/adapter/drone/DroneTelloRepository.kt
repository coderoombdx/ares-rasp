package com.coderoom.ares.adapter.drone

import com.coderoom.ares.adapter.drone.flight.FlightCommandProcessor
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandForward
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandLanding
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandStart
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandStop
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandTakeoff
import org.springframework.stereotype.Repository


@Repository
class DroneTelloRepository : DroneRepository {
    override fun lanceVol(): Boolean {
        return if (TelloDriver.launched) {
            false
        } else {
            FlightCommandProcessor()
                .addCommand(FlightCommandStart(TelloDriver))
                .addCommand(FlightCommandTakeoff(TelloDriver, 4000L))
                .addCommand(FlightCommandForward(TelloDriver, 4000L))
                .addCommand(FlightCommandLanding(TelloDriver, 4000L))
                .addCommand(FlightCommandStop(TelloDriver))
                .asyncProcessCommand()
            true
        }
    }

    object TelloDriver {
        var launched = false
    }
}

