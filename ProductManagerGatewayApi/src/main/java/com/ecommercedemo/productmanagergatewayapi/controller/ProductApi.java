package com.ecommercedemo.productmanagergatewayapi.controller;

import com.ecommercedemo.productmanagergatewayapi.entities.Product;
import com.ecommercedemo.productmanagergatewayapi.services.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {
    private RestClientService restClient;
    @Autowired
    public ProductApi(RestClientService client){
        this.restClient = client;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return this.restClient.get("/product/all");
    }
    @GetMapping("/{id}")
    public List<Product> getProductById(@PathVariable String id){
        return this.restClient.get("/product/"+id);
    }
    @GetMapping()
    public List<Product> getProductByName(@RequestParam(name="name") String name){
        return this.restClient.get("/product?name="+name);
    }
    @PostMapping("")
    public int addProduct(@RequestBody Product product){
        return this.restClient.post("/product", product);
    }

    @PutMapping("/{id}")
    public int updateProduct(@PathVariable String id, @RequestBody Product newProduct){
        return this.restClient.put("/product/"+id, newProduct);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable String id){
        return this.restClient.delete("/product/"+id);
    }
}
