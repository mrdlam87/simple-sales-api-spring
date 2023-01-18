package com.dlam.rest.webservices.simplesalesapi.repositories;

import com.dlam.rest.webservices.simplesalesapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
