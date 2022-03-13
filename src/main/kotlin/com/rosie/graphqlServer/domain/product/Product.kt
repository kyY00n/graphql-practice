package com.rosie.graphqlServer.domain.product

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("product")
class Product(
    @Id
    var id: Int = 0,
    val name: String,
    val categoryId: Int,
)