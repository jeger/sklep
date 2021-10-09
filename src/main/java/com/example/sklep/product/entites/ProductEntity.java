package com.example.sklep.product;

import com.example.sklep.warehouse.WarehouseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;

    private String name;

    @DecimalMin(value = "0.0")
    @Digits(integer = 7, fraction = 2)
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_details_id")
    private ProductDetailsEntity productDetailsEntity;

    @OneToOne(mappedBy = "productEntity", fetch = FetchType.LAZY)
    private WarehouseEntity warehouseEntity;
}
