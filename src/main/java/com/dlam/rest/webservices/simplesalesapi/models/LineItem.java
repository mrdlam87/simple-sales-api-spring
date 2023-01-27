package com.dlam.rest.webservices.simplesalesapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Lombok provides very handy annotations, like @Data,@Getters/@Setters which removes lot og boiler plate code

public class LineItem {
    // use primitives as they will take default value of 0
    // This is meant to be productId I think
    private Long id;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
