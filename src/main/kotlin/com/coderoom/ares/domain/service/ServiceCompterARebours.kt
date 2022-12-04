package com.coderoom.ares.domain.service

import com.coderoom.ares.adapter.StoreSingleton
import org.springframework.stereotype.Service

@Service
class ServiceCompterARebours {

    fun manageCompteARebours() {
        val compteARebours = StoreSingleton.compteARebours
        if (compteARebours > 0) {
            StoreSingleton.compteARebours--
        }
    }
}