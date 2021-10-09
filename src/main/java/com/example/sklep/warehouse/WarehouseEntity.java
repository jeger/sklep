package com.example.sklep.warehouse;

import com.example.sklep.product.entites.ProductEntity;
import lombok.*;

import javax.persistence.*;

@Entity(name = "Warehouse")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WarehouseEntity {

    @Id
    @GeneratedValue
    private Integer warehouseId;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    private Integer amount;

}
