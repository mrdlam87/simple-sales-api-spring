package com.dlam.rest.webservices.simplesalesapi.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoService {
    private static List<Product> products = new ArrayList<>();
    private static int productsCount = 0;

    static  {
        products.add(new Product(++productsCount,"Chrome Toaster",100.00));
        products.add(new Product(++productsCount,"Copper Kettle",49.99));
        products.add(new Product(++productsCount,"Mixing Bowl",20.00));
    }

    public List<Product> findAll(){
        return products;
    }
}
