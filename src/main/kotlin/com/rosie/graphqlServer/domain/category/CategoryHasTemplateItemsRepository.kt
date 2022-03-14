package com.rosie.graphqlServer.domain.category

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface CategoryHasTemplateItemsRepository : ReactiveCrudRepository<CategoryHasTemplateItems, Int> {
    fun findByCategoryId(categoryId: Int): Flux<CategoryHasTemplateItems>
}