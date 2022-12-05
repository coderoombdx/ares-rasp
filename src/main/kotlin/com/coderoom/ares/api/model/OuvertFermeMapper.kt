package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.OuvertFerme as OuvertFermeModel

fun OuvertFermeModel.toApiModel(): OuvertFerme {
    return when (this) {
        OuvertFermeModel.Ouvert -> OuvertFerme.OUVERT
        OuvertFermeModel.Ferme -> OuvertFerme.FERME
    }
}

enum class OuvertFerme(val value: String) {
    OUVERT("OUVERT"),
    FERME("FERME")
}


