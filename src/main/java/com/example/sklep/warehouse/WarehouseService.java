package com.example.sklep.warehouse;

import org.springframework.stereotype.Service;

@Service
public class WarehouseService {


    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public Integer checkProductAmount(int productId) throws ProductNotFoundException {
        return warehouseRepository.findByProductEntityProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException(ProductNotFoundException.WAREHOUSE_MESSAGE, productId))
                .getAmount();
    }
}
