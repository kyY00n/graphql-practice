package com.rosie.graphqlServer.graphql.dataloader

import com.rosie.graphqlServer.domain.category.CategoryAggregate
import com.rosie.graphqlServer.domain.category.ProductCategoryTemplates
import com.rosie.graphqlServer.graphql.CachedBatchLoader
import com.rosie.graphqlServer.graphql.annotation.QualifiedBatchLoader
import com.rosie.graphqlServer.graphql.model.InputGroupNodeTO
import com.rosie.graphqlServer.graphql.model.InputGroupNodeTypeTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.future.future
import org.dataloader.MappedBatchLoader
import org.springframework.stereotype.Component
import java.util.concurrent.CompletionStage

@QualifiedBatchLoader("productTemplatesInputGroupNodes")
@Component
class ProductTemplatesInputGroupNodeBatchLoader(
    private val categoryAggregate: CategoryAggregate,
    // private val businessAccountAggregator: BusinessAccountaggregator,
) : MappedBatchLoader<ProductTemplatesInputGroupNodeBatchLoader.Inputs, List<InputGroupNodeTO>>, CachedBatchLoader {
    data class Inputs(
        val categoryId: String,
    )

    override fun load(inputs: MutableSet<Inputs>): CompletionStage<Map<Inputs, List<InputGroupNodeTO>>> {
        val categoryIds: Set<Int> = inputs.map { it.categoryId.toInt() }.toSet()
        return CoroutineScope(Dispatchers.IO).future {
            val categoryIdToTemplates: Map<Int, List<ProductCategoryTemplates>> =
                categoryAggregate.findTemplatesByCategoryIds(categoryIds).toMap()
            inputs.associateWith { input ->
                categoryIdToTemplates[input.categoryId.toInt()]!!.map {
                    InputGroupNodeTO(
                        label = it.label,
                        type = InputGroupNodeTypeTO.valueOf(it.type),
                        dataKey = it.dataKey,
                        required = it.required,
                        placeholder = it.placeHolder,
                        helpText = it.helpText,
                        initialValue = it.initialValue
                    )
                }
            }

//        return CoroutineScope(Dispatchers.IO).future {
//            keys.associateWith {
//                listOf(
//                    InputGroupNodeTO(
//                        label = "?????? ??????",
//                        type = InputGroupNodeTypeTO.TEXTAREA,
//                        dataKey = "recommandTo",
//                        required = true,
//                        placeholder = "??????",
//                        helpText = "??? ????????? ???????????? ?????? ????????? ???????????? ???????????????.",
//                        initialValue = null
//                    ),
//                    InputGroupNodeTO(
//                        label = "?????? ??????",
//                        type = InputGroupNodeTypeTO.TEXTAREA,
//                        dataKey = "storeInfo",
//                        required = true,
//                        placeholder = null,
//                        helpText = "???????????? ????????? ?????????, ????????? ???????????? ????????? ??????????????? ????????? ?????? ??? ?????????.",
//                        initialValue = null
//                    ),
//                    InputGroupNodeTO(
//                        label = "?????? ??????",
//                        type = InputGroupNodeTypeTO.TEXTAREA,
//                        dataKey = "serviceInfo",
//                        required = false,
//                        placeholder = null,
//                        helpText = "?????? ?????? ??? ????????? ?????? ????????? ????????? ???????????????.",
//                        initialValue = null
//                    )
//                )
//            }
        }
    }

    override fun getCacheClass(): Class<*> = List::class.java

    override fun getCacheExpire() = 60
}
