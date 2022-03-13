package com.rosie.graphqlServer.domain.category

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CategoryRepository: CoroutineCrudRepository<Category, Int> {
}