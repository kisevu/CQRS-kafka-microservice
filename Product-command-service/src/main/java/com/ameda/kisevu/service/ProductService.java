package com.ameda.kisevu.service;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.dto.ProductEvent;
import com.ameda.kisevu.entity.Product;
import com.ameda.kisevu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public Product createProduct(ProductEvent productEvent){
        Product productDo = productRepository.save(productEvent.getProduct());
        ProductEvent event = new ProductEvent("CreateProduct",productDo);
        kafkaTemplate.send("product-event-topic",productEvent);
        return productDo;
    }
    public Product updateProduct(long productId, ProductEvent productEvent){
        var existingProduct = productRepository.findById(productId)
                .orElseThrow();
        Product newProduct = productEvent.getProduct();
        existingProduct.setProductName(newProduct.getProductName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setDescription(newProduct.getDescription());
        Product productDo = productRepository.save(existingProduct);
        ProductEvent event = new ProductEvent("UpdateProduct",productDo);
        kafkaTemplate.send("product-event-topic",event);
        return productDo;
    }
}
