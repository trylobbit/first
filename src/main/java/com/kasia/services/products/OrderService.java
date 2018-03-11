package com.kasia.services.products;

/**
 * Created by kasia on 10.03.18.
 */
public interface OrderService {
    void createOrder(String mail, Integer product, Integer amount);

}
