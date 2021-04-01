package com.example.sklep.warehouse;

import com.example.sklep.TooFewProductAvailableException;
import com.example.sklep.product.Product;
import org.springframework.stereotype.Component;

@Component
public class WarehouseFacade {

    private final WarehouseService warehouseService;

    public WarehouseFacade(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    public void checkIfAvailable(int productId, int expectedNewProductAmount) {
        int productAmountInWarehouse = warehouseService.checkProductAmount(productId);

        if (warehouseService.checkProductAmount(productId) < expectedNewProductAmount) {
            throw new TooFewProductAvailableException(productAmountInWarehouse, expectedNewProductAmount);
        }
    }
}
