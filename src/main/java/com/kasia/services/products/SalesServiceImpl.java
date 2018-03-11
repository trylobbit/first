package com.kasia.services.products;

import com.kasia.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by kasia on 08.03.18.
 */
@Service
@Transactional
public class SalesServiceImpl implements SalesService {

    private final ProductService productService;

    @Autowired
    public SalesServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    public void reducePrice(Product product, Integer percent) {

//        Iterable<Product> productsList = productService.findAll();

        BigDecimal multiply = product.getPrice().multiply(new BigDecimal(percent));
        BigDecimal newProductPrice = product.getPrice().subtract(multiply);
        product.setPrice(newProductPrice);
    }
}
