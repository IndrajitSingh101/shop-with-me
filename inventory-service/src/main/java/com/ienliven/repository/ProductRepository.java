package com.ienliven.repository;

import com.ienliven.Entity.Product;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {
    Flux<Product> findByCategory(String category);
}