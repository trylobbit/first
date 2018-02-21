package com.kasia.controllers.products;

import com.kasia.domain.products.Adress;
import com.kasia.domain.products.User;
import com.kasia.services.products.ProductService;
import com.kasia.services.products.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String newUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("adress", new Adress());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute User user){
        userService.addUser(user);
        return "users";
    }

}
