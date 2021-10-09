package com.example.sklep.product;

import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Builder
public class ProductDetailsDTO {
    private final int id;
    private final String description;
    private final String imagesPaths;
}
