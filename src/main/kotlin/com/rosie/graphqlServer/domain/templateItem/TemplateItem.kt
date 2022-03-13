package com.rosie.graphqlServer.domain.templateItem

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("template_item")
class TemplateItem(
    @Id
    var id: Int = 0,
    val name: String,
)