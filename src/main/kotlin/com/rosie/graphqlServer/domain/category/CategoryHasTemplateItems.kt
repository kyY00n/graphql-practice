package com.rosie.graphqlServer.domain.category

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("category_has_template_items")
class CategoryHasTemplateItems(
    @Id
    var id: Int = 0,
    val categoryId: Int,
    val templateItemId: Int,
)