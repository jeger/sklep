package com.example.sklep.cart;

import com.example.sklep.TooFewProductAvailableException;
import com.example.sklep.warehouse.ProductNotFoundException;
import com.example.sklep.warehouse.WarehouseFacade;
import org.springframework.stereotype.Component;

@Component
public class CartFacade {

    private final WarehouseFacade warehouseFacade;
    private final CartService cartService;

    public CartFacade(WarehouseFacade warehouseFacade, CartService cartService) {
        this.warehouseFacade = warehouseFacade;
        this.cartService = cartService;
    }

    public void checkProductAvailability(int productId, int amountOfProduct) throws ProductNotFoundException, TooFewProductAvailableException {
        int availableProductAmount = warehouseFacade.checkProductAmount(productId);

        if (availableProductAmount<amountOfProduct){
            throw new TooFewProductAvailableException(availableProductAmount,amountOfProduct);
        }
    }

    public void addProductToCart(int customerId, ProductDto productDto) {
        cartService.checkIfCartExist(customerId);
        int currProductAmount = warehouseFacade.checkProductAmount(productDto.getProductId());
        cartService.addProductToCart(customerId,currProductAmount, productDto);
    }

    public void createCart(Integer customerId) {
        cartService.createCart(customerId);
    }
}
