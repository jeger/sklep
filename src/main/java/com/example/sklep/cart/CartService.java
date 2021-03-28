package com.example.sklep.cart;

import com.example.sklep.TooFewProductAvailableException;
import com.example.sklep.warehouse.WarehouseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartService {
    private final Map<Integer, Cart> carts = new ConcurrentHashMap<>();


    public void addProductToCart(int customerId,int productAmountInWarehouse, ProductDto productDto) throws CartNotFoundException {
        Cart customerCart = carts.get(customerId);

        int productId = productDto.getProductId();
        int amountToAdd = productDto.getAmount();

        Optional<Integer> amountByProductIdInCart = customerCart.getAmountByProductIdInCart(productId);

        int expectedNewProductAmount = amountByProductIdInCart.orElse(0) + amountToAdd;
        if (productAmountInWarehouse<expectedNewProductAmount){
            throw new TooFewProductAvailableException(productAmountInWarehouse,expectedNewProductAmount);
        }

        customerCart.pushProduct(productId,amountToAdd);
    }

    public void checkIfCartExist(int customerId) {
        Cart cart = carts.get(customerId);
        if (cart == null) {
            throw new CartNotFoundException(customerId);
        }
    }

    public void createCart(Integer customerId) {
        carts.putIfAbsent(customerId, new Cart());
    }
}
