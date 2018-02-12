package com.kasia.domain.products;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long sn;
    private double price;
    private String clarity;
    private ProductType type;
    double carat;


    public Product() {
    }



    public Product(long id, long sn, double price, String clarity, ProductType type, double carat) {
        this.id = id;
        this.sn = sn;
        this.price = price;
        this.clarity = clarity;
        this.type = type;
        this.carat = carat;
    }

    public void setType(String type) {
        this.type = ProductType.valueOf(type);
    }

    public double getCarat() {
        return carat;
    }

    public void setCarat(double carat) {
        this.carat = carat;
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

    public long getSn() {
        return sn;
    }

    public void setSn(long sn) {
        this.sn = sn;
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