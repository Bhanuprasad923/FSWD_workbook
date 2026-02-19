package com.klu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.model.Product;
import com.klu.repo.Product_repo;

@Service
public class Product_service {

    private final Product_repo repo;

    public Product_service(Product_repo repo) {
        this.repo = repo;
    }

    // CREATE
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // READ BY ID
    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // UPDATE
    public Product updateProduct(Long id, Product newProduct) {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existing.setName(newProduct.getName());
        existing.setPrice(newProduct.getPrice());
        existing.setQuality(newProduct.getQuality());
        existing.setImageUrl(newProduct.getImageUrl());

        return repo.save(existing);
    }

    // DELETE
    public void deleteProduct(Long id) {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        repo.delete(existing);
    }
}
