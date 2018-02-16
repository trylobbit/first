package com.kasia.services.products;

import com.kasia.ProductRepository;
import com.kasia.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getProductList(Integer pageNumber, Integer pageSize, String property, String direction) {
        Sort sorting = new Sort(Sort.Direction.fromString(direction), property);

        PageRequest request = new PageRequest(pageNumber, pageSize, sorting);

        return productRepository.findAll(request);

    }

}
