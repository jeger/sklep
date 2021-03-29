package com.example.sklep.order;


import com.example.sklep.product.ProductDTO;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@Builder
@ToString
@EqualsAndHashCode
public final class OrderDTO {
    private final Map<ProductDTO, Integer> productToNumberMap;
    private final BigDecimal summaryPrice;
}
