package com.rosie.graphqlServer.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@EnableR2dbcAuditing(dateTimeProviderRef = "utcDateTimeProvider")
@EnableR2dbcRepositories(
    basePackages = [
        "com.rosie.graphqlServer",
    ],
)
@Configuration
class R2dbcConfig(
    private val connectionFactories: List<ConnectionFactory>
) : AbstractR2dbcConfiguration() {
    @Bean
    fun utcDateTimeProvider(): DateTimeProvider {
        return DateTimeProvider { Optional.of(LocalDateTime.now(ZoneOffset.UTC)) }
    }

    override fun connectionFactory(): ConnectionFactory {
        return connectionFactories[0]
    }
}