package com.rosie.graphqlServer.domain.category

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Flux

interface CategoryHasTemplateItemsRepository : CoroutineCrudRepository<CategoryHasTemplateItems, Int> {
    fun findByCategoryId(categoryId: Int): Flux<CategoryHasTemplateItems>
}