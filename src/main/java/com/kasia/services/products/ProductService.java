package com.kasia.services.products;

import com.kasia.domain.products.Product;
import com.kasia.domain.products.ProductsPaged;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    void deleteById(long id);

    void addProduct(Product product);

    Page<Product> getProductList(Integer pageNumber, Integer pageSize, String property, String filterByType, String direction);


    List<Product> getProductListPriceRange(Integer upRange, Integer downRange);


    Iterable<Product> findAll();
}