package com.example.sklep.cart;


import com.example.sklep.product.Product;
import com.example.sklep.product.ProductFacade;
import com.example.sklep.warehouse.WarehouseFacade;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Supplier;

@Component
public class CartFacade {

    private final WarehouseFacade warehouseFacade;
    private final CartService cartService;
    private final ProductFacade productFacade;

    public CartFacade(WarehouseFacade warehouseFacade, CartService cartService, ProductFacade productFacade) {
        this.warehouseFacade = warehouseFacade;
        this.cartService = cartService;
        this.productFacade = productFacade;
    }

    public void addProductToCart(int customerId, ProductAddedToCartDTO productAddedToCartDTO) {
        //Product amount validation
        cartService.checkIfCartExist(customerId);
        final int productId = productAddedToCartDTO.getProductId();
        int currProductAmount = warehouseFacade.checkProductAmount(productId);
        cartService.checkIfProductAmountEnough(customerId, currProductAmount, productAddedToCartDTO);

        Optional<Product> productByIdOptional = cartService.getProductFromCartById(customerId, productId);
        Product productById = productByIdOptional.orElseGet(new Supplier<Product>() {
            @Override
            public Product get() {
                return productFacade.getProductById(productId);
            }
        });

//        To samo co wyżej tylko lambda
//        Product productById = productByIdOptional.orElseGet(() -> productFacade.getProductById(productAddedToCartDTO.getProductId()));
        cartService.addProductToCart(productById, productAddedToCartDTO.getAmount(), customerId);
    }

    public void createCart(Integer customerId) {
        cartService.createCart(customerId);
    }

    public Cart getCardForCustomer(int customerId) {
        return cartService.getCart(customerId);
    }
}
