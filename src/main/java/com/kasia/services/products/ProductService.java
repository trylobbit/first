package com.kasia.services.products;

import com.kasia.domain.products.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    void deleteById(long id);

    void addProduct(Product product);

    Page<Product> getProductList(Integer pageNumber, Integer pageSize);

}