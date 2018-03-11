package com.kasia.services.products;

import com.kasia.domain.products.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void deleteById(long id);

    Product findById(long id);

    void deleteProduct(Product product);

    void addProduct(Product product);

    void saveProductOrAddNext(Product product);

    Page<Product> getProductList(Integer pageNumber, Integer pageSize, String property, String filterByType, String direction);


    List<Product> getProductListPriceRange(BigDecimal upRange, BigDecimal downRange);


    Iterable<Product> findAll();


    void decrementProductCounter(Product product);

    void reduceProductCounter(Product product, Integer amount);
}