package com.coderoom.ares.api.model

import java.io.Serializable

data class Health(
    val upSince: java.time.OffsetDateTime,
    val env: String? = null,
    val version: String? = null,
    val rev: String? = null,
    val commitDate: String? = null,
    val commitMessage: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 123
    }

}

