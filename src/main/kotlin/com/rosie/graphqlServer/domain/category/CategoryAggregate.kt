package com.rosie.graphqlServer.domain.category

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Component

@Component
class CategoryAggregate(
    private val categoryHasTemplateItemsRepository: CategoryHasTemplateItemsRepository,
) {
    suspend fun findTemplates(categoryId: Int): Flow<ProductCategoryTemplates> {
        return categoryHasTemplateItemsRepository.findByCategoryId(categoryId)
    }

    suspend fun findTemplatesByCategoryIds(categoryIds: Set<Int>): Map<Int, List<ProductCategoryTemplates>> {
        return categoryHasTemplateItemsRepository.findAllByCategoryIdIn(categoryIds)
            .toList()
            .groupBy { it.categoryId }
    }
}