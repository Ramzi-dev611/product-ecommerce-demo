package com.ecommercedemo.productmanagerreader.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product", createIndex = true)
public class Product {
    @Id
    private String id = "";
    private String name = "";
    private String description = "";
    private double price = 0.0;
    private int stock_quantity = 0;
}
