package com.dlam.rest.webservices.simplesalesapi.controllers;

import com.dlam.rest.webservices.simplesalesapi.models.Product;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import com.dlam.rest.webservices.simplesalesapi.services.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.generateResponse("success", HttpStatus.OK, repository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id) {
        return ResponseHandler.generateResponse("success", HttpStatus.OK, repository.findById(id).get());
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        return ResponseHandler.generateResponse("success", HttpStatus.CREATED, repository.save(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Product updatedProduct = repository.findById(id).map(prod -> {
            prod.setName(product.getName());
            prod.setPrice(product.getPrice());

            return repository.save(prod);
        }).get();

        return ResponseHandler.generateResponse("success", HttpStatus.CREATED, updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseHandler.generateResponse("success", HttpStatus.ACCEPTED, null);
    }
}
