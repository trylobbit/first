package com.kasia.domain.products;


public class Adress {
    private String country;
    private String city;
    private String code;
    private String street;
    private Integer houseNumber;

    public Adress(String country, String city, String code, String street, Integer houseNumber) {
        this.country = country;
        this.city = city;
        this.code = code;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Adress(){}

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}
