package com.coderoom.ares

import org.springframework.stereotype.Component
import java.util.*

@Component
class ScmInfos {

    private val properties: Properties by lazy {
        Properties().apply { load(ScmInfos::class.java.classLoader.getResourceAsStream("git.properties")) }
    }

    fun getVersion(): String = properties.getProperty("git.build.version", "")
    fun getCommitId(): String = properties.getProperty("git.commit.id", "")
    fun getCommitTime(): String = properties.getProperty("git.commit.time", "")
    fun getCommitMessage(): String = properties.getProperty("git.commit.message.short", "")

}
