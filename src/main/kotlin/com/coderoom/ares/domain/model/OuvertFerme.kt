package com.coderoom.ares.domain.model

sealed interface OuvertFerme {
    object Ouvert : OuvertFerme
    object Ferme : OuvertFerme
}