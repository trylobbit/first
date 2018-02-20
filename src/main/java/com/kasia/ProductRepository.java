package com.kasia;

import com.kasia.domain.products.Product;
import com.kasia.domain.products.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


    void deleteById(long id);

    Page<Product> findByType(ProductType type, Pageable pageable);
}


