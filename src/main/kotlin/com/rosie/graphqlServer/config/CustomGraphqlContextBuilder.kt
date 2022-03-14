package com.rosie.graphqlServer.config

import graphql.kickstart.spring.GraphQLSpringContext
import graphql.kickstart.spring.GraphQLSpringServerWebExchangeContext
import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebSocketSessionContext
import graphql.kickstart.spring.webflux.GraphQLSpringWebSocketSessionContext
import graphql.kickstart.spring.webflux.GraphQLSpringWebfluxContextBuilder
import org.dataloader.DataLoaderRegistry
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.web.server.ServerWebExchange

@Component
class CustomGraphqlContextBuilder(
    private val dataLoaderRegistry: DataLoaderRegistry
) : GraphQLSpringWebfluxContextBuilder {
    override fun build(webSocketSession: WebSocketSession): GraphQLSpringWebSocketSessionContext {
        return DefaultGraphQLSpringWebSocketSessionContext(dataLoaderRegistry, webSocketSession)
    }

    override fun build(serverWebExchange: ServerWebExchange): GraphQLSpringContext {
        return GraphQLSpringServerWebExchangeContext(dataLoaderRegistry, serverWebExchange)
    }
}