package com.kasia.services.products;

import com.kasia.ProductRepository;
import com.kasia.domain.products.Product;

import java.util.ArrayList;
import java.util.List;

import com.kasia.domain.products.ProductType;
import com.kasia.domain.products.ProductsPaged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Iterable<Product> findAll(){return productRepository.findAll();}

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

    public  List<Product> getProductListPriceRange(Integer downRange, Integer upRange){

        Iterable<Product> products = productRepository.findAll();
        List<Product> productsPriceRange = new ArrayList<>();

        for (Product product: products) {
            if (downRange < product.getPrice() && upRange> product.getPrice() ){
                productsPriceRange.add(product);
            }

        }
        return productsPriceRange;
    }

//    private List<Product> filterProducts(List<Product> products, String filter) {
//        List<Product> productsFiltered = new ArrayList<>();
//        for (Product product : products) {
//            if (product.getType() == ProductType.valueOf(filter)) {
//                productsFiltered.add(product);
//            }
//        }
//        return productsFiltered;
//    }


}
