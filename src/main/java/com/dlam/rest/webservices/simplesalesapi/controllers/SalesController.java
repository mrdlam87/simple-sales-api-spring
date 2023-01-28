package com.dlam.rest.webservices.simplesalesapi.controllers;

import com.dlam.rest.webservices.simplesalesapi.models.*;
import com.dlam.rest.webservices.simplesalesapi.services.ResponseHandler;
import com.dlam.rest.webservices.simplesalesapi.services.SaleDaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {
    // Similar comments as in ProductController
    private SaleDaoService service;

    SalesController(SaleDaoService service) {
        this.service = service;
    }

    @PostMapping("/sales")
    public ResponseEntity<Object> createSales(@RequestBody List<LineItem> lineItems) {
        Sale newSale = service.create(lineItems);

        return ResponseHandler.generateResponse("success", HttpStatus.OK, newSale);
    }

    @PostMapping("/sales/specials")
    /* The whole payload should be part of 1 RequestBody

    {
        linesItems: [],
        totalDiscount: 100
    }

    */
    public ResponseEntity<Object> createDiscountSales(@RequestBody List<LineItem> lineItems, @RequestParam Double discount) {
        SaleDiscount newSale = service.create(lineItems, discount);

        return ResponseHandler.generateResponse("success", HttpStatus.OK, newSale);
    }
}
