package com.kasia.services.products;

import com.kasia.domain.products.Product;
import com.kasia.domain.products.ProductType;
import com.kasia.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void reduceProductCounter(Product product, Integer amount) {
        Integer counter = product.getProductCounter();
        Integer updateCounter = counter - amount;
        product.setProductCounter(updateCounter);
        productRepository.save(product);
    }

    public Page<Product> getProductList(Integer pageNumber, Integer pageSize, String property, String filter, String direction) {
        Page<Product> products;
        Sort sorting = new Sort(Sort.Direction.fromString(direction), property);
        Pageable request = new PageRequest(pageNumber, pageSize, sorting);

        if (filter != null && !filter.isEmpty()) {
            products = productRepository.findByType(ProductType.valueOf(filter), request);

        } else {
            products = productRepository.findAll(request);
        }

        return products;
    }

    public List<Product> getProductListPriceRange(BigDecimal downRange, BigDecimal upRange) {

        Iterable<Product> products = productRepository.findAll();
        List<Product> productsPriceRange = new ArrayList<>();

        for (Product product : products) {
            if (downRange.compareTo(product.getPrice()) == -1 && upRange.compareTo(product.getPrice()) == 1) {
                productsPriceRange.add(product);
            }

        }
        return productsPriceRange;
    }

    public void saveProductOrAddNext(Product product) {
        Iterable<Product> products = productRepository.findAll();
        boolean exist = false;
        for (Product productInBase : products) {
            if (productInBase.equals(product)) {
                Integer counter = productInBase.getProductCounter();
                counter++;
                productInBase.setProductCounter(counter);
                exist = true;
            }

        }
        if (!exist) {
            product.setProductCounter(1);
            productRepository.save(product);

        }


    }

    public void decrementProductCounter(Product product) {
        List<Product> soldOut = new ArrayList<>();
        Integer counter = product.getProductCounter();
        if (counter > 0) {
            counter--;
            product.setProductCounter(counter);
        } else {
            soldOut.add(product);
            deleteById(product.getId());
        }

    }
}
