package com.kasia.domain.products;

/**
 * Created by kasia on 09.02.18.
 */
public enum ProductType {

    DIAMENT("diament"), SZMARAGD("szmaragd"), SZAFIR("szafir");

    private String name;

    ProductType(String name) {
        name = name;
    }

    public String getName() {
        return name;
    }
}
