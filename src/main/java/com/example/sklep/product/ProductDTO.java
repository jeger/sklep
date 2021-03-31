package com.example.sklep.product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public final class ProductDTO {
    private final int id;
    private final String name;
    private final BigDecimal priceUSD;
}
