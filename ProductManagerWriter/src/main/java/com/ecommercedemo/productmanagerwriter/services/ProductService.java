package com.ecommercedemo.productmanagerwriter.services;

import com.ecommercedemo.productmanagerwriter.entity.Product;
import com.ecommercedemo.productmanagerwriter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private EventEmitter emitter;
    private ProductRepository repository;
    @Autowired
    public ProductService(EventEmitter e, ProductRepository repo){
        this.emitter = e;
        this.repository = repo;
    }

    public int add(Product product){
        if (this.repository.save(product) != null){
            emitter.emmitAddedProduct(product);
            return 1;
        }
        return 0;
    }

    public int update(String id, Product p){
        Product updated = this.repository.findById(id).get();
        if (updated != null){
            updated.setName(p.getName().equals("") ? updated.getName() : p.getName());
            updated.setDescription(p.getDescription().equals("") ? updated.getDescription() : p.getDescription());
            updated.setPrice(p.getPrice() == 0 ? updated.getPrice() : p.getPrice());
            updated.setStock_quantity(p.getStock_quantity() == 0 ? updated.getStock_quantity() : p.getStock_quantity());
            this.repository.save(updated);
            this.emitter.emmitUpdatedProduct(updated);
            return 1;
        }
        return 0;
    }

    public int delete(String id){
        Product deleted = this.repository.findById(id).get();
        if (deleted != null){
            this.repository.delete(deleted);
            this.emitter.emmitDeletedProduct(id);
            return 1;
        }
        return 0;
    }

}
