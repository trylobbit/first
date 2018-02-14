package com.kasia.services.products;

import com.kasia.domain.products.Product;

import java.util.List;

public interface ProductService {

    public void deleteById(long id);
    public void addProduct(Product product);
    public void updateProduct(Product product);

}