package com.example.sklep.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public final class ProductAddedToCartDTO {
    final int productId;
    final int amount;
}
