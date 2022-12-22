package com.coderoom.ares

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiConfiguration {

    @Bean
    fun swaggerOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Mission Ares API")
                    .description("Apis de test du back de l'escape de la mission Ares")
            )

    }
}