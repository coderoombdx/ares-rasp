package com.coderoom.ares.adapter.tableauCommande

import com.coderoom.ares.domain.model.TableauCommande
import com.fazecast.jSerialComm.SerialPort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class TableauCommandeArduinoRepository : TableauCommandeRepository {
    private final val serialPort: SerialPort
    private final val logger: Logger = LoggerFactory.getLogger(javaClass)

    init {
//        val portName = "COM4"
        val portName = "ttyUSB0"
        serialPort = SerialPort.getCommPort(portName)
        serialPort.setComPortParameters(115200, 8, 1, 0)
        if (serialPort.openPort()) {
            logger.info("Serial port $portName is opened")
        } else {
            logger.error("Fail to open serial port $portName")
        }
    }

    override fun readData(): TableauCommande {
        val rfidSet = if (serialPort.isOpen) {
            try {
                if (serialPort.bytesAvailable() != 0) {
                    do {
                        val bytesAvailable = serialPort.bytesAvailable()
                        Thread.sleep(20) // To make sure arduino is not printing anymore
                    } while (serialPort.bytesAvailable() != bytesAvailable)
                    val readBuffer = ByteArray(serialPort.bytesAvailable())
                    serialPort.readBytes(readBuffer, readBuffer.size.toLong())
                    String(readBuffer).lines().filter { !it.startsWith("#") }.last()
                } else {
                    ""
                }
            } catch (e: Exception) {
                logger.info("Wrong format received")
                ""
            }
        } else {
            logger.info("Serial port ${serialPort.systemPortName} is not opened")
            ""
        }

        return TableauCommande(
            // interrupteurGeneralOn = (rfidSet == "1")
            interrupteurGeneralOn = true
        )
    }
}

