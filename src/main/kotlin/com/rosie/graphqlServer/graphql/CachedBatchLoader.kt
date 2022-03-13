package com.rosie.graphqlServer.graphql

interface CachedBatchLoader {
    fun getCacheExpire(): Int = 60

    fun getCacheClass(): Class<*>
}