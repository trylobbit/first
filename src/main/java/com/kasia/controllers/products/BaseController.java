package com.kasia.controllers.products;

import com.kasia.services.products.ProductService;
import org.springframework.data.domain.Page;
import com.kasia.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping("/base")
    public String viewBase(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, Model model) {

        Page<Product> allProducts = productService.getProductList(page, 10);
        model.addAttribute("products", allProducts.getContent());
        model.addAttribute("pages", allProducts.getTotalPages());
        model.addAttribute("actualPage", allProducts.getNumber());

        return "base";
    }

    @RequestMapping(value = "/delete-product-by-id", method = RequestMethod.POST)
    public String deleteProduct(@RequestParam long id) {
        productService.deleteById(id);
        return "redirect:/base";
    }


}

