package com.dlam.rest.webservices.simplesalesapi.models;

public class TotalItemDiscount extends TotalItem {
    private Double discount;

    public TotalItemDiscount(Long id, Double totalItemPrice) {
        super(id, totalItemPrice);
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
