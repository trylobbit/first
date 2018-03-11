package com.kasia.domain.products;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long sn;

    private BigDecimal price;

    private String clarity;

    private ProductType type;

    private double carat;

    @Column(name = "create_date")
    private Date date;

    @Column(name = "product_counter")
    private Integer productCounter;


    public Product() {
    }

    public Product(long id, long sn, BigDecimal price, String clarity, ProductType type, double carat, Date date, Integer productCounter) {
        this.id = id;
        this.sn = sn;
        this.price = price;
        this.clarity = clarity;
        this.type = type;
        this.carat = carat;
        this.date = date;
        this.productCounter = productCounter;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setProductCounter(Integer productCounter) {
        this.productCounter = productCounter;
    }

    public Integer getProductCounter() {
        return productCounter;
    }


    public double getCarat() {
        return carat;
    }

    public void setCarat(double carat) {
        this.carat = carat;
    }

    public void setType(String type) {
        this.type = ProductType.valueOf(type);
    }

    public ProductType getType() {
        return type;
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


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getClarity() {
        return clarity;
    }

    public void setClarity(String clarity) {
        this.clarity = clarity;
    }

 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return sn == product.sn;
    }

  */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (sn != product.sn) return false;
        if (Double.compare(product.carat, carat) != 0) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (clarity != null ? !clarity.equals(product.clarity) : product.clarity != null) return false;
        if (type != product.type) return false;
        if (date != null ? !date.equals(product.date) : product.date != null) return false;
        return productCounter != null ? productCounter.equals(product.productCounter) : product.productCounter == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (sn ^ (sn >>> 32));
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (clarity != null ? clarity.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(carat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
