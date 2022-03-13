package com.rosie.graphqlServer.domain.category

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("category")
class Category(
    @Id
    var id: Int = 0,
    val name: String,
)