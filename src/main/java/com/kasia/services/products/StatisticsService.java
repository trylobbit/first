package com.kasia.services.products;

import java.math.BigDecimal;
import java.util.Map;

public interface StatisticsService {
    Map<String, BigDecimal> averagePriceMap();
}
