package com.kasia.services.products;

import com.kasia.domain.products.Product;

import java.util.List;

public interface ProductService {

    void deleteById(long id);
    void addProduct(Product product);
    void updateProduct(Product product);

}