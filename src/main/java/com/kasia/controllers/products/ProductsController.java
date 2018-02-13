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
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add-product")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/add-product")
    public String productSubmit(@ModelAttribute Product product) {
        productRepository.save(product);
        return "result";
    }
}
