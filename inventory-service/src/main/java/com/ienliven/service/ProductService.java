package com.ienliven.service;

import com.ienliven.Entity.Product;
import com.ienliven.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> createProduct(Product product) {
        System.out.println(product);
        return productRepository.insert(product);
    }

    @Override
    public Flux<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

}