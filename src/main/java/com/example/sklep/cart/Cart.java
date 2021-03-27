package com.example.sklep.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    //TODO Co ze sprawdzaniem ilosci produktów, które mozna dodac??
    Map<Integer, Integer> productAmountMap = new HashMap<>();


    public void pushProduct(int productId, int amountOfProduct) {
        productAmountMap.computeIfPresent(productId,
                (product, currAmount) -> currAmount += amountOfProduct);
        productAmountMap.putIfAbsent(productId, amountOfProduct);
    }

}
