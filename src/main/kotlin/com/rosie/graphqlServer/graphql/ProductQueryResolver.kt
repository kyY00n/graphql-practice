package com.rosie.graphqlServer.graphql

import com.rosie.graphqlServer.graphql.dataloader.ProductTemplatesInputGroupNodeBatchLoader
import com.rosie.graphqlServer.graphql.model.InputGroupNodeTO
import com.rosie.graphqlServer.graphql.model.InputGroupTO
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class ProductQueryResolver : GraphQLQueryResolver {
    fun productTemplatesInputGroupByCategoryId(
        categoryId: String,
        env: DataFetchingEnvironment
    ): CompletableFuture<InputGroupTO> {
        val dataLoader = env.getDataLoader<ProductTemplatesInputGroupNodeBatchLoader.Inputs, List<InputGroupNodeTO>>(
            ProductTemplatesInputGroupNodeBatchLoader::class
        )

        return dataLoader.load(
            ProductTemplatesInputGroupNodeBatchLoader.Inputs(
                categoryId = categoryId
            )
        ).thenApply {
            InputGroupTO(it)
        }
    }
}