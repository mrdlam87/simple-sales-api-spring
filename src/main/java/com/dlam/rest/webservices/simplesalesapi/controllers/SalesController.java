package com.dlam.rest.webservices.simplesalesapi.controllers;

import com.dlam.rest.webservices.simplesalesapi.models.*;
import com.dlam.rest.webservices.simplesalesapi.repositories.OrderRepository;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import com.dlam.rest.webservices.simplesalesapi.repositories.SaleRepository;
import com.dlam.rest.webservices.simplesalesapi.services.ResponseHandler;
import com.dlam.rest.webservices.simplesalesapi.services.SaleDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SaleDaoService saleDaoService;

    @GetMapping("/sales")
    public ResponseEntity<Object> getAllSales() {
        return ResponseHandler.generateResponse("success", HttpStatus.OK, saleRepository.findAll());
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> getSale(@PathVariable Long id) {
        return ResponseHandler.generateResponse("success", HttpStatus.OK, saleRepository.findById(id));
    }

    @GetMapping("/sales/{id}/orders")
    public ResponseEntity<Object> getSaleOrders(@PathVariable Long id) {
        List<Order> orders = orderRepository.findBySaleId(id);

        return ResponseHandler.generateResponse("success", HttpStatus.OK, orders);
    }

    @PostMapping("/sales")
    public ResponseEntity<Object> createSales(@RequestBody List<LineItem> lineItems) {
        return ResponseHandler.generateResponse("success", HttpStatus.OK, saleDaoService.create(lineItems));
    }

//    @PostMapping("/sales/specials")
//    public ResponseEntity<Object> createDiscountSales(@RequestBody List<LineItem> lineItems, @RequestParam Double discount) {
//        SaleDiscount newSale = service.create(lineItems, discount);
//
//        return ResponseHandler.generateResponse("success", HttpStatus.OK, newSale);
//    }
}
