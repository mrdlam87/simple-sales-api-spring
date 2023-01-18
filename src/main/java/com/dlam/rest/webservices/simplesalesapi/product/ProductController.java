package com.dlam.rest.webservices.simplesalesapi.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductDaoService service;

    public ProductController(ProductDaoService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.findAll();
    }
}
