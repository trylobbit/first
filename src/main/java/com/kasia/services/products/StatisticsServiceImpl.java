package com.kasia.services.products;


import com.kasia.domain.products.Product;
import com.kasia.domain.products.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ProductService productService;

    public Map<String, BigDecimal> averagePriceMap() {


        Map<String, BigDecimal> averagePrice = new HashMap<>();

        BigDecimal sumValueDiament = BigDecimal.ZERO;
        Integer diamentCounter = 0;
        BigDecimal sumValueSzmaragd = BigDecimal.ZERO;
        Integer szmaragdCounter = 0;
        BigDecimal sumValueSzafir = BigDecimal.ZERO;
        Integer szafirCounter = 0;


        for (Product product : productService.findAll())
            if (product.getType() == ProductType.DIAMENT) {
                diamentCounter++;
                sumValueDiament = sumValueDiament.add(product.getPrice());
            } else if (product.getType() == ProductType.SZMARAGD) {
                szmaragdCounter++;
                sumValueSzmaragd = sumValueSzmaragd.add(product.getPrice());

            } else if (product.getType() == ProductType.SZAFIR) {
                szafirCounter++;
                sumValueSzafir = sumValueSzafir.add(product.getPrice());

            }


        BigDecimal averagePriceDiament = sumValueDiament.divide(BigDecimal.valueOf(diamentCounter), 2, RoundingMode.CEILING);
        BigDecimal averagePriceSzmaragd = sumValueSzmaragd.divide(BigDecimal.valueOf(szmaragdCounter), 2, RoundingMode.CEILING);
        BigDecimal averagePriceSzafir = sumValueSzafir.divide(BigDecimal.valueOf(szafirCounter), 2, RoundingMode.CEILING);

        averagePrice.put("DIAMENT", averagePriceDiament);
        averagePrice.put("SZMARAGD", averagePriceSzmaragd);
        averagePrice.put("SZAFIR", averagePriceSzafir);

        return averagePrice;
    }


}




