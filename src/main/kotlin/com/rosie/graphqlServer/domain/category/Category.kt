package com.rosie.graphqlServer.domain.category

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("category")
class Category(
    @Id
    var id: Long = 0,
    val name: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}