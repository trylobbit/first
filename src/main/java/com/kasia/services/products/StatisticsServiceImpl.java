package com.kasia.services.products;


import com.kasia.domain.products.Product;
import com.kasia.domain.products.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private ProductService productService;

    public Map<String, Double> averagePriceMap() {


        Map<String, Double> averagePrice = new HashMap<>();

        double sumValueDiament = 0;
        Integer diamentCounter = 0;
        double sumValueSzmaragd = 0;
        Integer szmaragdCounter = 0;
        double sumValueSzafir = 0;
        Integer szafirCounter = 0;


        for (Product product : productService.findAll())
            if (product.getType() == ProductType.DIAMENT) {
                diamentCounter++;
                sumValueDiament = sumValueDiament + product.getPrice();
            } else if (product.getType() == ProductType.SZMARAGD) {
                szmaragdCounter++;
                sumValueSzmaragd = sumValueSzmaragd + product.getPrice();

            } else if (product.getType() == ProductType.SZAFIR) {
                szafirCounter++;
                sumValueSzafir = sumValueSzafir + product.getPrice();

            }


        Double averagePriceDiament = sumValueDiament / diamentCounter;
        Double averagePriceSzmaragd = sumValueSzmaragd / szmaragdCounter;
        Double averagePriceSzafir = sumValueSzafir / szafirCounter;

        averagePrice.put("DIAMENT", averagePriceDiament);
        averagePrice.put("SZMARAGD", averagePriceSzmaragd);
        averagePrice.put("SZAFIR", averagePriceSzafir);

        return  averagePrice;
    }



}




