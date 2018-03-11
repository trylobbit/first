package com.kasia.domain.products;

import org.springframework.data.domain.Page;

import java.util.List;


/**
 * Created by kasia on 19.02.18.
 */
public class ProductsPaged {

    private List<Product> products;

    private Integer totalPages;

    private Integer currentPage;

    public ProductsPaged(List<Product> products, Integer totalPages, Integer currentPage) {
        this.products = products;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public ProductsPaged(Page<Product> products) {
        this.products = products.getContent();
        this.totalPages = products.getTotalPages();
        this.currentPage = products.getNumber();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }
}
