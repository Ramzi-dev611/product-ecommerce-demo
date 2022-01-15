package com.ecommercedemo.productmanagerwriter.repository;

import com.ecommercedemo.productmanagerwriter.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findById(String id);
}
