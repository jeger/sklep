package com.example.sklep.cart;

import com.example.sklep.product.Product;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartService {
    //Key: customerId
    private final Map<Integer, Cart> carts = new ConcurrentHashMap<>();


    public void addProductToCart(Product product, int amountToAdd, int customerId) throws CartNotFoundException {
        Cart customerCart = carts.get(customerId);
        customerCart.pushProduct(product, amountToAdd);
    }


    public int calculateExpectedNewProductAmount(Product product, Cart customerCart, int amountToAdd) {
        int currentNumberOfThisProductInCart = customerCart.getAmountByProductInCart(product);

        return currentNumberOfThisProductInCart + amountToAdd;
    }

    public Cart getCartOrThrow(int customerId) throws CartNotFoundException {
        Cart cart = carts.get(customerId);
        if (cart == null) {
            throw new CartNotFoundException(customerId);
        }
        return cart;
    }

    public void createCart(Integer customerId) {
        carts.putIfAbsent(customerId, new Cart());
    }
}
