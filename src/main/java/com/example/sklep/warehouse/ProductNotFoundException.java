package com.example.sklep.warehouse;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int productId) {
        super(String.format("Nie znaleziono produktu o id %s", productId));
    }
}
