package com.rosie.graphqlServer.graphql.dataloader

import com.rosie.graphqlServer.domain.category.CategoryHasTemplateItemsRepository
import com.rosie.graphqlServer.domain.category.CategoryRepository
import com.rosie.graphqlServer.graphql.CachedBatchLoader
import com.rosie.graphqlServer.graphql.annotation.QualifiedBatchLoader
import com.rosie.graphqlServer.graphql.model.InputGroupNodeTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.future.future
import org.dataloader.MappedBatchLoader
import org.springframework.stereotype.Component
import java.util.concurrent.CompletionStage

@QualifiedBatchLoader("productTemplatesInputGroupNodes")
@Component
class ProductTemplatesInputGroupNodeBatchLoader(
    private val productTemplateItemsRepository: CategoryHasTemplateItemsRepository,
    private val categoryRepository: CategoryRepository,
): MappedBatchLoader<ProductTemplatesInputGroupNodeBatchLoader.Input, List<InputGroupNodeTO>>, CachedBatchLoader {
    data class Input(
        val categoryId: String,
    )

    override fun load(inputs: MutableSet<Input>): CompletionStage<MutableMap<Input, List<InputGroupNodeTO>>> {
        // 여기서는 뭘하는 건지 모르겠다.
        val categoryIds = inputs.map { it.categoryId }.toSet()
        val templateItems = productTemplateItemsRepository
        CoroutineScope(Dispatchers.IO).future {

            categoryIds.associateWith {

            }
        }
        TODO("")
    }

    override fun getCacheClass() = List::class.java

    override fun getCacheExpire() = 60


}