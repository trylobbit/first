package com.kasia;

import com.kasia.domain.products.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    void deleteById(long id);

}


