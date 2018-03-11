package com.kasia.repositories;

import com.kasia.domain.products.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kasia on 10.03.18.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
