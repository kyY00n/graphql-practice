package com.rosie.graphqlServer.graphql

import com.rosie.graphqlServer.graphql.annotation.QualifiedBatchLoader
import graphql.schema.DataFetchingEnvironment
import org.dataloader.DataLoader
import kotlin.reflect.KClass

fun <K, V> DataFetchingEnvironment.getDataLoader(c: KClass<*>): DataLoader<K, V> {
    val name = (
            c.annotations.find {
                it is QualifiedBatchLoader
            } as? QualifiedBatchLoader ?: throw IllegalAccessException()
            ).name

    return this.getDataLoader(name)
}