package com.ecommercedemo.productmanagerwriter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private String id = "";
    private String name = "";
    private String description = "";
    private double price = 0.0;
    private int stock_quantity = 0;
}
