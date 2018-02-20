package com.kasia.domain.products;
import org.springframework.data.convert.Jsr310Converters;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    @Column(name = "create_date")
    private Date date;

    public Product() {
    }



    public Product(long id, long sn, double price, String clarity, ProductType type, double carat, Date date) {
        this.id = id;
        this.sn = sn;
        this.price = price;
        this.clarity = clarity;
        this.type = type;
        this.carat = carat;
        this.date = date;
    }

    public void setType(String type) {
        this.type = ProductType.valueOf(type);
    }

    public void setDate(Date date) {this.date = date;}
    public Date getDate(){return date;}


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