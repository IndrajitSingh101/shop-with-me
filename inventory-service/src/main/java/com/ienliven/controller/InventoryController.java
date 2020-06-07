package com.ienliven.controller;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.ienliven.Entity.Product;
import com.ienliven.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class InventoryController {
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public Mono<String> getResponse(ServerHttpRequest request, ServerHttpResponse response) {
        HttpHeaders headers = request.getHeaders();
        headers.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
        Mono<String> data = Mono.just("hello from reactive web");
        return data;
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> insertProduct(@RequestBody Product product) {
        System.out.println(product);
        return productService.createProduct(product);
    }

    @GetMapping("/findByCategory/{category}")
    public Flux<Product> getProductsByCategory(@PathVariable String category) {
        System.out.println(category);
        return productService.getProductByCategory(category);
    }

}
