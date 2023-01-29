package com.dlam.rest.webservices.simplesalesapi.models;

import jakarta.persistence.*;


@Entity
public class Sale {

    @Id
    @GeneratedValue
    private Long id;
    private Double total = 0.0;
    private String status = "In progress";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
                ", total=" + total +
                ", status='" + status + '\'' +
                '}';
    }
}
