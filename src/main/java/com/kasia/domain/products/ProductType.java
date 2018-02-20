package com.kasia.domain.products;

public enum ProductType {

    DIAMENT("diament"), SZMARAGD("szmaragd"), SZAFIR("szafir");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
