package com.dlam.rest.webservices.simplesalesapi.controllers;

import com.dlam.rest.webservices.simplesalesapi.models.*;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SalesController {
    private final ProductRepository productRepository;

    SalesController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/sales")
    public ResponseEntity<Object> createSales(@RequestBody List<LineItem> lineItems) {
        Sale newSale = new Sale(lineItems);
        List<TotalItem> totalItems = new ArrayList<>();

        lineItems.stream().forEach(sale -> {
            Double price = productRepository.findById(sale.getId()).get().getPrice();
            Double totalItemPrice = sale.getQuantity() * price;
            newSale.setTotalPrice(newSale.getTotalPrice() + totalItemPrice);

            TotalItem item = totalItems.stream().filter(totalItem -> totalItem.getId()
                    .equals(sale.getId())).findFirst().orElse(null);

            if (item != null) {
                item.setTotalPrice(item.getTotalPrice() + totalItemPrice);
            } else {
                totalItems.add(new TotalItem(sale.getId(), totalItemPrice));
            }
        });
        newSale.setTotalItems(totalItems);

        return new ResponseEntity<Object>(newSale, HttpStatus.OK);
    }

    @PostMapping("/sales/specials")
    public ResponseEntity<Object> createDiscountSales(@RequestBody List<LineItem> lineItems, @RequestParam Double discount) {
        SaleDiscount newSale = new SaleDiscount(lineItems, discount);
        List<TotalItemDiscount> totalItems = new ArrayList<>();

        lineItems.stream().forEach(lineItem -> {
            Double price = productRepository.findById(lineItem.getId()).get().getPrice();
            Double totalItemPrice = lineItem.getQuantity() * price;
            newSale.setTotalPrice(newSale.getTotalPrice() + totalItemPrice);

            TotalItem item = totalItems.stream().filter(totalItem -> totalItem.getId()
                    .equals(lineItem.getId())).findFirst().orElse(null);

            if (item != null) {
                item.setTotalPrice(item.getTotalPrice() + totalItemPrice);
            } else {
                totalItems.add(new TotalItemDiscount(lineItem.getId(), totalItemPrice));
            }
        });

        Double discountRate = discount / newSale.getTotalPrice();
        newSale.setTotalPrice(newSale.getTotalPrice() - discount);

        totalItems.forEach(item -> {
            Double originalPrice = item.getTotalPrice();
            item.setDiscount(discountRate * item.getTotalPrice());
            item.setTotalPrice(originalPrice - item.getDiscount());
        });
        newSale.setTotalItems(totalItems);

        return new ResponseEntity<Object>(newSale, HttpStatus.OK);
    }
}
