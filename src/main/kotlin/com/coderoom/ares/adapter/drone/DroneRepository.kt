package com.coderoom.ares.adapter.drone

interface DroneRepository {
    fun lanceVol(): Boolean
    fun relanceVol()
    fun vole()
}