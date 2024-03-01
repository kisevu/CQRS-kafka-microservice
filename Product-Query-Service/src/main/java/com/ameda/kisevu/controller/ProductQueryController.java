package com.ameda.kisevu.controller;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.entity.Product;
import com.ameda.kisevu.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/query")
@RequiredArgsConstructor
public class ProductQueryController {
    private final ProductQueryService productQueryService;

    @GetMapping
    public List<Product> products(){
        return productQueryService.getProducts();
    }
}
