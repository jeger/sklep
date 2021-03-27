package com.example.sklep.warehouse;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WarehouseEntity {

    @Id
    @GeneratedValue
    Integer productId;

    Integer amount;

}
