package com.ecommercedemo.productmanagerreader.services;

import com.ecommercedemo.productmanagerreader.entities.Product;
import com.ecommercedemo.productmanagerreader.repositories.ProductRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerService {
    private ProductRepository repository;
    @Autowired
    public ListenerService(ProductRepository repo){
        this.repository = repo;
    }

    @KafkaListener(topics = "add-products", groupId = "group_id")
    public void receiveAdded(String message){
        Product product = new Gson().fromJson(message, Product.class);
        repository.save(product);
    }

    @KafkaListener(topics ="update-products", groupId = "group_id")
    public void receiveUpdated(String message){
        Product product = new Gson().fromJson(message, Product.class);
        repository.save(product);
    }
    @KafkaListener(topics ="delete-products", groupId = "group_id")
    public void receiveDeleted(String message){
        repository.deleteById(message);
    }
}
