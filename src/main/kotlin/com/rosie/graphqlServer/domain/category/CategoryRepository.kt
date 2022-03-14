package com.rosie.graphqlServer.domain.category

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CategoryRepository : ReactiveCrudRepository<Category, Int> {
}