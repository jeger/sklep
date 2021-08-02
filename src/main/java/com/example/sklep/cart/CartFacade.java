package com.example.sklep.cart;


import com.example.sklep.product.Product;
import com.example.sklep.product.ProductFacade;
import com.example.sklep.warehouse.WarehouseFacade;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public void addProductToCart(int customerId, ProductAddedToCartDTO productAddedToCartDTO) throws CartNotFoundException {
        Cart customerCart = cartService.getCartOrThrow(customerId);

        int productId = productAddedToCartDTO.getProductId();
        int productAmount = productAddedToCartDTO.getAmount();

        Optional<Product> productByIdOptional = customerCart.getProductById(productId);
        Product product = productByIdOptional.orElseGet(() -> productFacade.getProductById(productId));

        warehouseFacade.checkIfAvailable(productId, productAmount);

        cartService.setProductToCart(product, productAmount, customerId);
    }

    public void createCart(Integer customerId) {
        cartService.createCart(customerId);
    }

    public Cart getCartOrThrow(int customerId) {
        return cartService.getCartOrThrow(customerId);
    }
}

//        Product product = productByIdOptional.orElseGet(new Supplier<Product>() {
//            @Override
//            public Product get() {
//                return productFacade.getProductById(productId);
//            }
//        });
