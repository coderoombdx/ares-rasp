package com.coderoom.ares.api

import com.coderoom.ares.ScmInfos
import com.coderoom.ares.api.model.Health
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.context.ApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId

@RestController
@CrossOrigin
@RequestMapping("/api/health")
class HealthApi(
    private val context: ApplicationContext,
    private val scmInfos: ScmInfos
) {
    @Operation(summary = "Retourne l'état de l'application", description = "200")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Tout va bien")])
    @GetMapping
    fun getHealth(): ResponseEntity<Any> {
        return ResponseEntity(
            Health(
                env = System.getenv("HOSTNAME"),
                upSince = OffsetDateTime.ofInstant(Instant.ofEpochMilli(context.startupDate), ZoneId.systemDefault()),
                version = scmInfos.getVersion(),
                rev = scmInfos.getCommitId(),
                commitDate = scmInfos.getCommitTime(),
                commitMessage = scmInfos.getCommitMessage()
            ), HttpStatus.OK
        )
    }
}
