package com.kasia.controllers.products;

import com.kasia.domain.products.Product;
import com.kasia.domain.products.ProductsPaged;
import com.kasia.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private ProductService productService;


    @GetMapping("/base")
    public String viewBase(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(value = "sort", required = false, defaultValue = "id") String property,
                           @RequestParam(value = "filterByType", required = false) String filterByType,
                           @RequestParam(value = "direction", required = false, defaultValue = "ASC") String direction,
                           Model model) {

        Page<Product> products = productService.getProductList(page, 50, property, filterByType, direction);

        model.addAttribute("products", products.getContent());
        model.addAttribute("pages", products.getTotalPages());
        model.addAttribute("actualPage", products.getNumber());
        return "base";
    }
    @GetMapping("/range")
    public String priceRange(@RequestParam(value = "downRange", required = false, defaultValue = "0")Integer downRange,
                             @RequestParam(value = "upRange", required = false, defaultValue = "100000") Integer upRange,
                             Model model)
    {
        List<Product> products = productService.getProductListPriceRange(downRange, upRange);
        model.addAttribute("products", products);

        return "range";
    }


    @RequestMapping(value = "/delete-product-by-id", method = RequestMethod.POST)
    public String deleteProduct(@RequestParam long id) {
        Product deleteProduct= productService.findById(id);
        productService.decrementProductCounter(deleteProduct);
//  productService.deleteById(id);
        return "redirect:/base";
    }


}

