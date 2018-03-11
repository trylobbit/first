package com.kasia.controllers.products;

import com.kasia.services.products.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by kasia on 10.03.18.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/order")
    public String createOrder(Model model, Principal principal) {
        String userMail = principal.getName();
        Integer productId = 73;
        Integer amount = 2;
        orderService.createOrder(userMail, productId, amount);
        model.addAttribute("message", "dwddwedew");
//        model.addAttribute("order", new Order(user, orderItem));
        return "order";
    }


}
