package com.kasia.repositories;

import com.kasia.domain.products.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kasia on 10.03.18.
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
