package com.ameda.kisevu.service;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.entity.Product;
import com.ameda.kisevu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
