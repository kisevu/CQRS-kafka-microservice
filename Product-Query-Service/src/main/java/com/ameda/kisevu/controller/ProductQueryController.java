package com.ameda.kisevu.controller;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.dto.ProductEvent;
import com.ameda.kisevu.entity.Product;
import com.ameda.kisevu.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/query")
public class ProductQueryController {
    @Autowired
    private ProductQueryService productQueryService;

    @GetMapping
    public List<Product> products(){
        return productQueryService.getProducts();
    }
}
