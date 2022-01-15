package com.ecommercedemo.productmanagerreader.controllers;

import com.ecommercedemo.productmanagerreader.entities.Product;
import com.ecommercedemo.productmanagerreader.repositories.ProductRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {
    private ProductRepository repository;
    public ProductController(@Autowired ProductRepository repository){
        this.repository = repository;
    }
    @GetMapping("all")
    public List<Product> getProducts(){
        Iterable<Product> products =this.repository.findAll();
        ArrayList<Product> output = new ArrayList<Product>();
        for (Product p: products) {
            output.add(p);
        }
        return output;
    }
    @GetMapping("")
    public List<Product> getProductsByName(@RequestParam(name="name") String name){
        return this.repository.getProductsByName(name);
    }

    @GetMapping("{id}")
    public List<Product> getProductById(@PathVariable() String id){
        List<Product> output =  new ArrayList<>();
        output.add(this.repository.getProductById(id));
        return output;
    }

}
