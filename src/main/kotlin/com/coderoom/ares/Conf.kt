package com.coderoom.ares

import org.springframework.stereotype.Component

@Component
class Conf(
    val banner: Banner = Banner(),
    val version: String = "1.0",
    val arduino: Arduino = Arduino()
) {
    data class Banner(
        val location: String = "location"
    )

    data class Arduino(
        val port: String = "COM2"
    )
}