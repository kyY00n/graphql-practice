package com.rosie.graphqlServer.domain.product

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProductRepository : ReactiveCrudRepository<Product, Int> {
}