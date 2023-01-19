package com.dlam.rest.webservices.simplesalesapi.models;

import java.util.List;

public class SaleDiscount {

    private List<LineItem> lineItems;
    private List<TotalItemDiscount> totalItems;
    private Double totalPrice = 0.0;

    private Double discount = 0.0;

    public SaleDiscount(List<LineItem> lineItems, Double discount) {
        this.lineItems = lineItems;
        this.discount = discount;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<TotalItemDiscount> getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(List<TotalItemDiscount> totalItems) {
        this.totalItems = totalItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
