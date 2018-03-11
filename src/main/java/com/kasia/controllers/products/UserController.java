package com.kasia.controllers.products;

import com.kasia.domain.products.Adress;
import com.kasia.domain.products.User;
import com.kasia.services.products.AdressService;
import com.kasia.services.products.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdressService adressService;


    @GetMapping("/user")
    public String newProductForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        Adress adress = new Adress();
        model.addAttribute("adress", adress);

        return "user";
    }

    @GetMapping("/login")
    public String userLog(Model model) {
        User userLog = new User();
        model.addAttribute("user", userLog);
        return "login";
    }
    /*@PostMapping("/login")
    public String userLogin(Model model){

    }*/

    @PostMapping("/user")
    public String userSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult, @ModelAttribute Adress adress, Model model) {
        //if(userService.userFormComplete(user)){
//        adress.setUser(user);
        // user.setAdress(adress);
        //User user1 = userService.addUser(user);
        //  return "redirect:/users";}
        //else{model.addAttribute("message", "Please, fill out personal data form!");
        // return "user";}
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Please, fill out personal data form!");
            return "user";
        } else {
            user.setAdress(adress);
            User user1 = userService.addUser(user);
            return "redirect:/users";
        }
    }


    @GetMapping("/users")
    public String usersView(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}


