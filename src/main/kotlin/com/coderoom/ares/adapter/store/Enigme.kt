package com.coderoom.ares.adapter.store

sealed class Enigme(
    val id: String,
    val description: String,
    var resolu: Boolean,
    var code: String?
)

object EnigmeCablePhotovoltaique : Enigme(
    id = "cable",
    description = "Relier le cable des panneaux photovoltaiques",
    resolu = false,
    code = null
)

object EnigmeInterrupteurGeneral : Enigme(
    id = "inter_general",
    description = "Allumer l'interrupteur générale pour eclairer la station",
    resolu = false,
    code = null
)
