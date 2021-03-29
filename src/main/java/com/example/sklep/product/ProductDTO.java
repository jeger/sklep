package com.example.sklep.product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public final class ProductDTO {
    private final int id;
    private final String name;
    private final BigDecimal priceUSD;
}
