package com.example.sklep;

public class TooFewProductAvailableException extends RuntimeException {
    public TooFewProductAvailableException(int availableProductAmount, int amountOfProduct) {
    }
}
