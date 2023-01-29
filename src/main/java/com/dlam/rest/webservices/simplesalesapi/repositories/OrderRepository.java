package com.dlam.rest.webservices.simplesalesapi.repositories;

import com.dlam.rest.webservices.simplesalesapi.models.Order;
import com.dlam.rest.webservices.simplesalesapi.models.OrderID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderID> {
}
