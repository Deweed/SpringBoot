package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Product;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1L;

    public List<Product> getProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    private long id;
    private String name;

    public ProductService(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId) {
        Optional<Product> product = Optional.ofNullable(products.stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null));
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); 
    }
}