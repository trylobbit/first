package com.kasia.services.products;

import java.util.List;
import com.kasia.ProductRepository;
import com.kasia.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }
    public void deleteById(long id){
        productRepository.deleteById(id);
    }
    public void updateProduct(Product product){
        productRepository.updateProduct(product);
    }

}
