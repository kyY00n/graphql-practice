package com.rosie.graphqlServer.config

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.rosie.graphqlServer.graphql.CachedBatchLoader
import com.rosie.graphqlServer.graphql.CustomCacheMap
import com.rosie.graphqlServer.graphql.annotation.QualifiedBatchLoader
import graphql.kickstart.tools.ObjectMapperConfigurer
import graphql.kickstart.tools.SchemaParserOptions
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.dataloader.BatchLoader
import org.dataloader.DataLoader
import org.dataloader.DataLoaderOptions
import org.dataloader.DataLoaderRegistry
import org.dataloader.MappedBatchLoader
import org.dataloader.MappedBatchLoaderWithContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.CompletableFuture

@Configuration
class GraphqlConfig {
    @Bean
    fun getDataloaderRegistry(
        mappedBatchLoaders: List<MappedBatchLoader<*, *>>,
        mappedBatchLoaderWithContexts: List<MappedBatchLoaderWithContext<*, *>>,
        batchLoaders: List<BatchLoader<*, *>>,
    ): DataLoaderRegistry = DataLoaderRegistry().apply {
        mappedBatchLoaders.forEach {
            prepareDataLoader(it) { name, options ->
                this.register(name, DataLoader.newMappedDataLoader(it, options))
            }
        }
        mappedBatchLoaderWithContexts.forEach {
            prepareDataLoader(it) { name, options ->
                if (name == "baIsFollowings" || name == "baIsManagers") options.setCachingEnabled(
                    false
                )
                this.register(name, DataLoader.newMappedDataLoader(it, options))
            }
        }
        batchLoaders.forEach {
            prepareDataLoader(it) { name, options ->
                this.register(name, DataLoader(it, options))
            }
        }
    }

    private fun prepareDataLoader(it: Any, cb: (name: String, option: DataLoaderOptions) -> Unit) {
        val name = (
                it::class.annotations.find {
                    it is QualifiedBatchLoader
                } as? QualifiedBatchLoader
                )

            ?.name

        val options = if (it is CachedBatchLoader) {
            optionWithCacheMap(it.getCacheExpire(), it.getCacheClass())
        } else {
            DataLoaderOptions()

        }

        cb(name!!, options)
    }

    private fun <T> optionWithCacheMap(expireInSeconds: Int = 10, clazz: Class<T>): DataLoaderOptions {
        return DataLoaderOptions.newOptions()
            .setCacheMap(CustomCacheMap<Any, CompletableFuture<T>>(expireInSeconds))
    }

    @ExperimentalCoroutinesApi
    @Bean
    fun schemaParserOptions(): SchemaParserOptions {
        return SchemaParserOptions.newOptions()
            .objectMapperConfigurer(objectMapperConfigurer())
            .build()
    }

    @Bean
    fun objectMapperConfigurer(): ObjectMapperConfigurer {
        return ObjectMapperConfigurer { mapper, _ ->
            mapper.registerModules(
                JavaTimeModule().apply {
                    val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    this.addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer(dateTimeFormat))
                    this.addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer(dateTimeFormat))
                },
            )
        }
    }

}