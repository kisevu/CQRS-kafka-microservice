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

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(long productId, Product product){
        var existingProduct = productRepository.findById(productId)
                .orElseThrow();
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        return productRepository.save(existingProduct);
    }
}
