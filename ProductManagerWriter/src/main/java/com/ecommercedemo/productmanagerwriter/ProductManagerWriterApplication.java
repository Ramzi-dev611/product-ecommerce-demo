package com.ecommercedemo.productmanagerwriter;

import com.ecommercedemo.productmanagerwriter.entity.Product;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagerWriterApplication {

    public static void main(String[] args) {
//        Product p = new Product(
//                "ahhah",
//                "fals",
//                "nems",
//                15.5,
//                2
//        );
//        System.out.println(new Gson().toJson(p));
        SpringApplication.run(ProductManagerWriterApplication.class, args);
    }

}
