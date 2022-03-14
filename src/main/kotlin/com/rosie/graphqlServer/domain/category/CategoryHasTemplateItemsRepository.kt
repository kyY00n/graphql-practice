package com.rosie.graphqlServer.domain.category

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CategoryHasTemplateItemsRepository : CoroutineCrudRepository<ProductCategoryTemplates, Int> {
    fun findByCategoryId(categoryId: Int): Flow<ProductCategoryTemplates>
    fun findAllByCategoryIdIn(categoryIds: Set<Int>): Flow<ProductCategoryTemplates>
}