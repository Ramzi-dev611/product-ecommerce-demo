package com.ecommercedemo.productmanagerwriter.services;

import com.ecommercedemo.productmanagerwriter.entity.Product;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventEmitter {
    private static final String ADDTOPIC = "add-products";
    private static final String UPDATETOPIC = "update-products";
    private static final String DELETETOPIC = "delete-products";
    private KafkaTemplate <String, String> kafkaTemplate;
    @Autowired
    public EventEmitter(KafkaTemplate<String,String> template){
        this.kafkaTemplate = template;
    }

    public void emmitAddedProduct(Product product){
        this.kafkaTemplate.send(ADDTOPIC, new Gson().toJson(product));
    }

    public void emmitUpdatedProduct(Product product){
        this.kafkaTemplate.send(UPDATETOPIC, new Gson().toJson(product));
    }

    public void emmitDeletedProduct(String id){
        this.kafkaTemplate.send(DELETETOPIC, id);
    }
}
