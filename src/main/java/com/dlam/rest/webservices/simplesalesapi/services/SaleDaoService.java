package com.dlam.rest.webservices.simplesalesapi.services;

import com.dlam.rest.webservices.simplesalesapi.models.*;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Services are annotated with @Service
@Component
public class SaleDaoService {

    // SaleService should interact with Product service, not directl with productRepository
    private final ProductRepository productRepository;

    // Glad we have constructor based dependency injection.
    // Doing this in all classes result in lot of boiler plate code, so we use lombok annotations.
    // In this case, we can get rid of this constructor, and use @RequiredArgsConstructor
    SaleDaoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Please specify in method name what are we creating
    public Sale create(List<LineItem> lineItems) {
        Sale newSale = new Sale(lineItems);
        List<TotalItem> totalItems = new ArrayList<>();

        // if we have 5 items for same, we would be hitting db query 5 times.
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

        return newSale;
    }

    // Please specify in method name what are we creating
    public SaleDiscount create(List<LineItem> lineItems, Double discount) {
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
            item.setDiscount(discountRate * item.getTotalPrice());
            item.setTotalPrice(item.getTotalPrice() - item.getDiscount());
        });
        newSale.setTotalItems(totalItems);

        return newSale;
    }
}
