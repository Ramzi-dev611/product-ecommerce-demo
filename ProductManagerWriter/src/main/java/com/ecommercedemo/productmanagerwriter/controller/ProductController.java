package com.ecommercedemo.productmanagerwriter.controller;

import com.ecommercedemo.productmanagerwriter.entity.Product;
import com.ecommercedemo.productmanagerwriter.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService service;
    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping("")
    public int addProduct(@RequestBody Product product){
        return this.service.add(product);
    }

    @PutMapping("/{id}")
    public int updateProduct(@PathVariable String id, @RequestBody Product p){
        return this.service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable String id){
        return this.service.delete(id);
    }
}
