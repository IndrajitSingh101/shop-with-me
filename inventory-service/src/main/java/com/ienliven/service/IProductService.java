package com.ienliven.service;

import com.ienliven.Entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
    Mono<Product> createProduct(Product product);

    Flux<Product> getProductByCategory(String category);
}