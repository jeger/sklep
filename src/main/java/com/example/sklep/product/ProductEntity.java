package com.example.sklep.product;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity(name = "Product")
//@Setter
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue
    private int productId;

    private String name;

    @DecimalMin(value = "0.0")
    @Digits(integer = 7, fraction = 2)
    private BigDecimal price;
}
