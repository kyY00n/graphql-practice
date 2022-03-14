package com.rosie.graphqlServer.domain.category

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component

@Component
class CategoryAggregate(
    private val categoryRepository: CategoryRepository,
    private val categoryHasTemplateItemsRepository: CategoryHasTemplateItemsRepository,
) {
    suspend fun findTemplates(categoryId: Int) {
//        categoryHasTemplateItemsRepository.findByCategoryId(categoryId).map { categoryTemplate ->
//            templateItemsRepository.findById(categoryTemplate.templateItemId)
//        }.asFlow().toList()
    }
}