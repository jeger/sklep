package com.example.sklep.cart;

import com.example.sklep.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cart {
    //TODO Co ze sprawdzaniem ilosci produktów, które mozna dodac??
    private final Map<Product, Integer> productAmountMap = new HashMap<>();


    public void pushProduct(Product product, int amountOfProduct) {
        productAmountMap.computeIfPresent(product, (productCurr, currAmount) -> currAmount += amountOfProduct);
        productAmountMap.putIfAbsent(product, amountOfProduct);
    }

    public int getAmountByProductInCart(Product product) {
        Integer amountInCart = productAmountMap.get(product);
        if (amountInCart == null) {
            return 0;
        }
        return amountInCart;
    }

    public Optional<Product> getProductById(int productId) {
        return productAmountMap.keySet()
                .stream().filter(product -> product.getId() == productId)
                .findFirst();
    }
}
