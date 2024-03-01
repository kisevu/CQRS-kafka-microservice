package com.ameda.kisevu.service;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.dto.ProductEvent;
import com.ameda.kisevu.entity.Product;
import com.ameda.kisevu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @KafkaListener(topics = "product-event-topic",groupId = "my-group")
    public  void processProductEvents(ProductEvent productEvent){
        Product product = productEvent.getProduct();
        if(productEvent.getEventType().equals("CreateProduct")){
            productRepository.save(product);
        }if(productEvent.getEventType().equals("UpdateProduct")){
          Product  existingProduct = productRepository.findById(product.getProductId()).orElseThrow();
          existingProduct.setProductName(product.getProductName());
          existingProduct.setPrice(product.getPrice());
          existingProduct.setDescription(product.getDescription());
          productRepository.save(existingProduct);
        }
    }
}
