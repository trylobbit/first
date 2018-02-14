package com.kasia;

import com.kasia.domain.products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    void deleteById(long id);

//    void updateProduct(Product product);

}
