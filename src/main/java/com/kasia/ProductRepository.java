package com.kasia;


import com.kasia.domain.products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
//        , PagingAndSortingRepository<Product, Long>
{

    @Transactional
    void deleteById(long id);
//    public Page findAll(Pageable pageable);
}
