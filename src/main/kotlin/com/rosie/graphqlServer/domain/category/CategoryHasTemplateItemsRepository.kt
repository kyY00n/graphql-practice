package com.rosie.graphqlServer.domain.category

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CategoryHasTemplateItemsRepository : CoroutineCrudRepository<CategoryHasTemplateItems, Int> {
    fun findByCategoryId(categoryId: Int): Flow<CategoryHasTemplateItems>
    fun findAllByCategoryIdIn(categoryIds: Set<Int>): Flow<CategoryHasTemplateItems>
}