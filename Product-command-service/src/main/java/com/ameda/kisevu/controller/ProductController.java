package com.ameda.kisevu.controller;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.entity.Product;
import com.ameda.kisevu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/command")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,
                                 @RequestBody Product product){
        return productService.updateProduct(productId,product);
    }
}
