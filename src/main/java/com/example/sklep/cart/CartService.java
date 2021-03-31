package com.example.sklep.cart;

import com.example.sklep.TooFewProductAvailableException;
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

    public void checkIfProductAmountEnough(int customerId, int productAmountInWarehouse, ProductAddedToCartDTO productAddedToCartDTO) {
        Cart customerCart = carts.get(customerId);

        int productId = productAddedToCartDTO.getProductId();
        int amountToAdd = productAddedToCartDTO.getAmount();

        Optional<Integer> amountByProductIdInCart = customerCart.getAmountByProductIdInCart(productId);

        int expectedNewProductAmount = amountByProductIdInCart.orElse(0) + amountToAdd;
        if (productAmountInWarehouse < expectedNewProductAmount) {
            throw new TooFewProductAvailableException(productAmountInWarehouse, expectedNewProductAmount);
        }
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

    public Cart getCart(int customerId) {
        return this.carts.get(customerId);
    }

    public Optional<Product> getProductFromCartById(int costumerId, int productId) {
        Cart customerCart = carts.get(costumerId);
        return customerCart.getProductById(productId);
    }
}
