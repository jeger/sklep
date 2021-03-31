package com.example.sklep.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Product")
//@Setter
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue
    private long productId;

    private String name;
}
