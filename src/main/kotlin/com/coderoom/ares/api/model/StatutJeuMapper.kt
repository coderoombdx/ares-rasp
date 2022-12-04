package com.coderoom.ares.api.model

import com.coderoom.ares.domain.model.Jeu
import com.coderoom.ares.api.model.Jeu as JeuApiModel
import com.coderoom.ares.api.model.Station as StationApiModel


fun Jeu.toApiModel() = JeuApiModel(
    compteARebours = this.compteARebours,
    station = StationApiModel(
        lumiereGeneraleAllumee = this.station.lumiereGeneraleAllumee
    )
)
