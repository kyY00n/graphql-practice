package com.rosie.graphqlServer.domain.category

import com.rosie.graphqlServer.domain.templateItem.TemplateItem
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TemplateItemsRepository: CoroutineCrudRepository<TemplateItem, Int> {
}