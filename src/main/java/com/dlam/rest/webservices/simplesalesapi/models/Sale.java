package com.dlam.rest.webservices.simplesalesapi.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Sale {

    @Id
    @GeneratedValue
    private Long id;

    private String status;

    public Sale() {
    }

    public Sale(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
