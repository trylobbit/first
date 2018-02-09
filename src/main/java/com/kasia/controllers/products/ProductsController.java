package com.kasia.controllers.products;

import com.kasia.domain.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by kasia on 09.02.18.
 * 2
 */

@Controller
public class ProductsController {

    @GetMapping("/product")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/product")
    public String productSubmit(@ModelAttribute Product product) {
        return "result";
    }
}
