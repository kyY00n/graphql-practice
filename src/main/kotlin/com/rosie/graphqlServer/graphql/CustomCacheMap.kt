package com.rosie.graphqlServer.graphql

import org.dataloader.CacheMap
import org.dataloader.impl.DefaultCacheMap
import java.util.concurrent.CompletableFuture

class CustomCacheMap<U, V>(
    private val expireInSeconds: Int,
) : DefaultCacheMap<U, V>() {
    private val expireMap = mutableMapOf<U, Long>()

    private fun isActiveOrRemove(key: U): Boolean {
        val expiresAt = expireMap[key] ?: return false

        val now = System.currentTimeMillis()
        val active = now <= expiresAt

        if (!active) {
            this.delete(key)
        }

        return active
    }

    override fun containsKey(key: U): Boolean {
        return if (isActiveOrRemove(key)) {
            super.containsKey(key)
        } else false
    }

    override fun get(key: U): V? {
        return if (isActiveOrRemove(key)) {
            super.get(key)
        } else null
    }

    override fun set(key: U, value: V): CacheMap<U, V> {
        val now = System.currentTimeMillis()
        expireMap[key] = now + expireInSeconds * 1000L
        return super.set(key, value)
    }

    override fun delete(key: U): CacheMap<U, V> {
        expireMap.remove(key)
        return super.delete(key)
    }

    override fun clear(): CacheMap<U, V> {
        expireMap.clear()
        return super.clear()
    }
}
