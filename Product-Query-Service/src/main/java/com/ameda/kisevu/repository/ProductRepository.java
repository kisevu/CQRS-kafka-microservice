package com.ameda.kisevu.repository;/*
*
@author ameda
@project CQRS-kafka-microservice
*
*/

import com.ameda.kisevu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
