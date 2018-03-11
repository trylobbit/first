package com.kasia.services.products;

import com.kasia.domain.products.Order;
import com.kasia.domain.products.OrderItem;
import com.kasia.domain.products.Product;
import com.kasia.domain.products.User;
import com.kasia.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kasia on 10.03.18.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(String mail, Integer productId, Integer amount) {

        User user = userService.getByMail(mail);
        Product product = productService.findById(productId);

        OrderItem orderItem = orderItemService.createOrderItem(new OrderItem(product, amount));
        Set<OrderItem> orderItemSet = new HashSet<>();
        orderItemSet.add(orderItem);
        Order order = new Order(user, orderItemSet);
        orderRepository.save(order);
        Integer productCounter = product.getProductCounter();
        if (productCounter > amount) {
            productService.reduceProductCounter(product, amount);
        } else if (productCounter.equals(amount)) {
            productService.reduceProductCounter(product, productCounter);
        } else {
            throw new IllegalArgumentException("Amount should be lower than:" + productCounter);
        }


    }
}
