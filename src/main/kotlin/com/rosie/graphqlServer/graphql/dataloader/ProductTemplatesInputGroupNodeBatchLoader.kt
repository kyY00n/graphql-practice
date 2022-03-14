package com.rosie.graphqlServer.graphql.dataloader

import com.rosie.graphqlServer.domain.category.CategoryHasTemplateItemsRepository
import com.rosie.graphqlServer.domain.category.CategoryRepository
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
    // private val productTemplateAggregator: ProductTemplateAggregator,
    // private val businessAccountAggregator: BusinessAccountaggregator,
) : MappedBatchLoader<ProductTemplatesInputGroupNodeBatchLoader.Inputs, List<InputGroupNodeTO>>, CachedBatchLoader {
    data class Inputs(
        val categoryId: String,
    )

    override fun load(keys: MutableSet<Inputs>): CompletionStage<Map<Inputs, List<InputGroupNodeTO>>> {
//        val categoryIds = keys.map { it.categoryId }.toSet()



        return CoroutineScope(Dispatchers.IO).future { keys.associateWith {
            listOf(
                InputGroupNodeTO(
                    label = "추천 대상",
                    type = InputGroupNodeTypeTO.TEXTAREA,
                    dataKey = "recommandTo",
                    required = true,
                    placeholder = "미정",
                    helpText = "이 체험을 추천하고 싶은 사람은 누구인지 알려주세요.",
                    initialValue = null
                ),
                InputGroupNodeTO(
                    label = "가게 소개",
                    type = InputGroupNodeTypeTO.TEXTAREA,
                    dataKey = "storeInfo",
                    required = true,
                    placeholder = null,
                    helpText = "체험하는 공간이 어떤지, 얼마나 전문성이 있는지 소개한다면 믿음을 가질 수 있어요.",
                    initialValue = null
                ),
                InputGroupNodeTO(
                    label = "이용 안내",
                    type = InputGroupNodeTypeTO.TEXTAREA,
                    dataKey = "serviceInfo",
                    required = false,
                    placeholder = null,
                    helpText = "체험 신청 전 알아야 하는 사항이 있다면 알려주세요.",
                    initialValue = null
                )
            )
        } }
    }

    override fun getCacheClass(): Class<*> = List::class.java

    override fun getCacheExpire() = 60
}
