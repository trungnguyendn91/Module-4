package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "product_name")
    private String productName;
    private String type;
    private String brand;
    private String country;
    private boolean cost;

    public Product() {
    }

    public Product(int id, String productName, String type, String brand, String country, boolean cost) {
        this.id = id;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.country = country;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getCost() {
        return cost;
    }

    public void setCost(boolean cost) {
        this.cost = cost;
    }
}
