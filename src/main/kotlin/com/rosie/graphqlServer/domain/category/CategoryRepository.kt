package com.rosie.graphqlServer.domain.category

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CategoryRepository : CoroutineCrudRepository<Category, Int> {
}