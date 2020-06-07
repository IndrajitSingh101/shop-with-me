package com.ienliven.controller;

import com.ienliven.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.function.Consumer;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
public class OrderController {

    // essential to keep this way for interservice call, soon to be replaced with reactive feign
    private WebClient.Builder webClientBuilder;

    @Autowired
    public OrderController(WebClient.Builder webClientBuilder){
        this.webClientBuilder=webClientBuilder;
    }

    @GetMapping("/checkInventory")
    public Mono<ResponseEntity<String>> getInventory() {
        ProductConsumer productConsumer=new ProductConsumer() {
            @Override
            public void updateProductInventory(Product p,Product item) {
                if(p.getCategory().equals(item.getCategory())&&p.getProductName().equals(item.getProductName())) {
                    System.out.println(p + ": exists");
                }
            }
        };
        Product item=Product.builder().category("Computer").productName("hp").build();
        this.webClientBuilder.build().get().uri("http://inventory-service/findByCategory/{category}", "Computer").accept(APPLICATION_JSON).retrieve()
                .bodyToFlux(Product.class).subscribe(p -> productConsumer.updateProductInventory(p, item));
       return Mono.just(new ResponseEntity<>("success",HttpStatus.OK));
    }
}

