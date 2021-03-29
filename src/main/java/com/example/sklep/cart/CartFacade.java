package com.example.sklep.cart;


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

    public void addProductToCart(int customerId, ProductAddedToCartDTO productAddedToCartDTO) {
        cartService.checkIfCartExist(customerId);
        int currProductAmount = warehouseFacade.checkProductAmount(productAddedToCartDTO.getProductId());
        cartService.addProductToCart(customerId,currProductAmount, productAddedToCartDTO);
    }

    public void createCart(Integer customerId) {
        cartService.createCart(customerId);
    }

    public Cart getCardForCustomer(int customerId) {
        return cartService.getCart(customerId);
    }
}
