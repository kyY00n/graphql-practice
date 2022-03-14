package com.rosie.graphqlServer.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.EntityResponse.fromObject
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class SimpleRouter {
    class SimpleRes(
        val str: String
    )
    @Bean
    fun route() = router {
        GET("/route") { _ -> ServerResponse.ok().bodyValue(SimpleRes("hi"))}
    }
}