package com.kasia.services.products;

import com.kasia.domain.products.Product;

/**
 * Created by kasia on 08.03.18.
 */
public interface SalesService {
    void reducePrice(Product product, Integer percent);
}
