package com.dlam.rest.webservices.simplesalesapi.models;

public class TotalItem {
    private Long id;

    private Double totalPrice;

    public Long getId() {
        return id;
    }

    public TotalItem() {
    }

    public TotalItem(Long id, Double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
