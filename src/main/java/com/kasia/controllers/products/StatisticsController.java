package com.kasia.controllers.products;

import com.kasia.services.products.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping ("/map")
    public String viewMap(Model model) {
        model.addAttribute("averagePrice", statisticsService.averagePriceMap());
        return "statistics";
    }


}

