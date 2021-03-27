package com.example.sklep.warehouse;

import org.springframework.stereotype.Component;

@Component
public class WarehouseFacade {

    private final WarehouseService warehouseService;

    public WarehouseFacade(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    public int checkProductAmount(int productId) throws ProductNotFoundException {
        return warehouseService.checkProductAmount(productId);
    }
}
