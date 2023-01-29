package com.dlam.rest.webservices.simplesalesapi.repositories;

import com.dlam.rest.webservices.simplesalesapi.models.Order;
import com.dlam.rest.webservices.simplesalesapi.models.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, OrderID> {
    @Query(value = "SELECT * FROM orders WHERE sale_id = ?1", nativeQuery = true)
    List<Order> findBySaleId(Long id);
}
