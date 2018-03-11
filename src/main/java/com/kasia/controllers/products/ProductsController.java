package com.kasia.controllers.products;

import com.kasia.domain.products.Product;
import com.kasia.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add-product")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/add-product")
    public String productSubmit(@ModelAttribute Product product) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        product.setDate(new Date());
        productService.saveProductOrAddNext(product);
//        productRepository.save(product);
        return "result";
    }


}
