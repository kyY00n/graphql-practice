package com.rosie.graphqlServer.graphql

import com.rosie.graphqlServer.graphql.dataloader.ProductTemplatesInputGroupNodeBatchLoader
import com.rosie.graphqlServer.graphql.model.InputGroupNodeTO
import com.rosie.graphqlServer.graphql.model.InputGroupTO
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

class ProductQueryResolver : GraphQLQueryResolver {
    fun productTemplatesInputGroupByCategoryId(
        categoryId: String,
        env: DataFetchingEnvironment
    ): CompletableFuture<InputGroupTO> {
        val dataLoader = env.getDataLoader<ProductTemplatesInputGroupNodeBatchLoader.Input, List<InputGroupNodeTO>>(
            ProductTemplatesInputGroupNodeBatchLoader::class
        )

        return dataLoader.load(
            ProductTemplatesInputGroupNodeBatchLoader.Input(
                categoryId = "1"
            )
        ).thenApply {
            InputGroupTO(it)
        }
    }
}