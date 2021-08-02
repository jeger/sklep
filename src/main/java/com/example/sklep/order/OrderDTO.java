package com.example.sklep.order;


import com.example.sklep.product.ProductDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@ToString
@Builder
@Getter
@EqualsAndHashCode
public final class OrderDTO {
    private final Map<ProductDTO, Integer> productToNumberMap;
    private final BigDecimal summaryPrice;
}
