package com.ameda.kisevu.service;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
}
