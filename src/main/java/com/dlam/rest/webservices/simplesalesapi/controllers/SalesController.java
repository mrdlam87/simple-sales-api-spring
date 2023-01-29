package com.dlam.rest.webservices.simplesalesapi.controllers;

import com.dlam.rest.webservices.simplesalesapi.models.*;
import com.dlam.rest.webservices.simplesalesapi.repositories.OrderRepository;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import com.dlam.rest.webservices.simplesalesapi.repositories.SaleRepository;
import com.dlam.rest.webservices.simplesalesapi.services.ResponseHandler;
import com.dlam.rest.webservices.simplesalesapi.services.SaleDaoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/sales")
    public ResponseEntity<Object> createSales(@RequestBody List<LineItem> lineItems) {
        Sale newSale = saleDaoService.create(lineItems);

        return ResponseHandler.generateResponse("success", HttpStatus.OK, newSale);
    }

//    @PostMapping("/sales/specials")
//    public ResponseEntity<Object> createDiscountSales(@RequestBody List<LineItem> lineItems, @RequestParam Double discount) {
//        SaleDiscount newSale = service.create(lineItems, discount);
//
//        return ResponseHandler.generateResponse("success", HttpStatus.OK, newSale);
//    }
}
