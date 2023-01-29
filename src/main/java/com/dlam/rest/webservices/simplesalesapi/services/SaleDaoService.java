package com.dlam.rest.webservices.simplesalesapi.services;

import com.dlam.rest.webservices.simplesalesapi.models.*;
import com.dlam.rest.webservices.simplesalesapi.repositories.OrderRepository;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import com.dlam.rest.webservices.simplesalesapi.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleDaoService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Sale create(List<LineItem> lineItems) {
        Sale sale = new Sale();
        saleRepository.save(sale);

        lineItems.forEach(item -> {
            Product product = productRepository.findById(item.getId()).get();
            OrderID orderID = new OrderID(sale, product);
            Order order = new Order();
            order.setId(orderID);
            order.setQuantity(item.getQuantity());
            order.setUnitPrice(product.getPrice());
            order.setSubtotal(item.getQuantity() * product.getPrice());
            orderRepository.save(order);
            sale.setTotal(sale.getTotal() + item.getQuantity() * product.getPrice());
        });

        saleRepository.save(sale);
        return sale;
    }

//    public Sale create(List<LineItem> lineItems) {
//        Sale newSale = new Sale(lineItems);
//        List<TotalItem> totalItems = new ArrayList<>();
//
//        lineItems.stream().forEach(sale -> {
//            Double price = productRepository.findById(sale.getId()).get().getPrice();
//            Double totalItemPrice = sale.getQuantity() * price;
//            newSale.setTotalPrice(newSale.getTotalPrice() + totalItemPrice);
//
//            TotalItem item = totalItems.stream().filter(totalItem -> totalItem.getId()
//                    .equals(sale.getId())).findFirst().orElse(null);
//
//            if (item != null) {
//                item.setTotalPrice(item.getTotalPrice() + totalItemPrice);
//            } else {
//                totalItems.add(new TotalItem(sale.getId(), totalItemPrice));
//            }
//        });
//        newSale.setTotalItems(totalItems);
//
//        return newSale;
//    }

//    public SaleDiscount create(List<LineItem> lineItems, Double discount) {
//        SaleDiscount newSale = new SaleDiscount(lineItems, discount);
//        List<TotalItemDiscount> totalItems = new ArrayList<>();
//
//        lineItems.stream().forEach(lineItem -> {
//            Double price = productRepository.findById(lineItem.getId()).get().getPrice();
//            Double totalItemPrice = lineItem.getQuantity() * price;
//            newSale.setTotalPrice(newSale.getTotalPrice() + totalItemPrice);
//
//            TotalItem item = totalItems.stream().filter(totalItem -> totalItem.getId()
//                    .equals(lineItem.getId())).findFirst().orElse(null);
//
//            if (item != null) {
//                item.setTotalPrice(item.getTotalPrice() + totalItemPrice);
//            } else {
//                totalItems.add(new TotalItemDiscount(lineItem.getId(), totalItemPrice));
//            }
//        });
//
//        Double discountRate = discount / newSale.getTotalPrice();
//        newSale.setTotalPrice(newSale.getTotalPrice() - discount);
//
//        totalItems.forEach(item -> {
//            item.setDiscount(discountRate * item.getTotalPrice());
//            item.setTotalPrice(item.getTotalPrice() - item.getDiscount());
//        });
//        newSale.setTotalItems(totalItems);
//
//        return newSale;
//    }
}
