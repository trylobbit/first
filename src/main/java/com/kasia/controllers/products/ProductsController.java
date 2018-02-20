package com.kasia.controllers.products;

import com.kasia.ProductRepository;
import com.kasia.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.util.calendar.BaseCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.time.format.DateTimeFormatter.ISO_DATE;

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        product.setDate(new Date());
        productRepository.save(product);
        return "result";
    }
}
