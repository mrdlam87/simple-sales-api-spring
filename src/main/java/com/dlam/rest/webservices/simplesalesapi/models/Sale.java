package com.dlam.rest.webservices.simplesalesapi.models;

import java.util.List;

public class Sale {

    private List<LineItem> lineItems;
    private List<TotalItem> totalItems;
    private Double totalPrice = 0.0;

    public Sale(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<TotalItem> getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(List<TotalItem> totalItems) {
        this.totalItems = totalItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
