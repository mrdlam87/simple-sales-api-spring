package com.dlam.rest.webservices.simplesalesapi.repositories;

import com.dlam.rest.webservices.simplesalesapi.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
