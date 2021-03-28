package com.example.sklep;

import com.example.sklep.warehouse.ProductNotFoundException;
import com.example.sklep.warehouse.WarehouseFacade;
import org.springframework.stereotype.Component;

@Component
public class CartFacade {

    private final WarehouseFacade warehouseFacade;

    public CartFacade(WarehouseFacade warehouseFacade) {
        this.warehouseFacade = warehouseFacade;
    }

    public void checkProductAvailability(int productId, int amountOfProduct) throws ProductNotFoundException, TooFewProductAvailableException {
        int availableProductAmount = warehouseFacade.checkProductAmount(productId);

        if (availableProductAmount<amountOfProduct){
            throw new TooFewProductAvailableException(availableProductAmount,amountOfProduct);
        }
    }
}
