package com.kasia.controllers.products;

import com.kasia.ProductRepository;
import com.kasia.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaseController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/base")
    public String viewBase(Model model) {
        Iterable<Product> allProducts = productRepository.findAll();
        model.addAttribute("products", allProducts);

        return "base";
    }

    @PostMapping("/base")
    public String productDelete(@ModelAttribute Product product) {
        productRepository.delete(product);
        return "base";
    }
}
