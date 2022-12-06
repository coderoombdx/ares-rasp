package com.coderoom.ares.domain.service

import com.coderoom.ares.adapter.store.InMemoryStoreRepository
import org.springframework.stereotype.Service

@Service
class ServiceMessage(
    private val repository: InMemoryStoreRepository
) {
    fun updateMessage(value: String?) {
        repository.setMessageAide(value)
    }
}