package com.kasia.domain.products;

public class Product {

    private long id;
    private double price;
    private String clarity;
    private ProductType type;

    public Product() {
    }

    public Product(long id, double price, String clarity, ProductType type) {
        this.id = id;
        this.price = price;
        this.clarity = clarity;
        this.type = type;
    }

    public void setType(String type) {
        this.type = ProductType.valueOf(type);
    }

    public ProductType getType() {
        return type ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClarity(){ return clarity;}

    public void setClarity(String clarity) { this.clarity = clarity;}

}