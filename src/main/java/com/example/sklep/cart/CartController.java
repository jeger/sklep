package com.example.sklep.cart;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class CartController {
//    private final CartRepository cartRepository;

    private final Map<Integer, Cart> carts = new ConcurrentHashMap<>();

//    @PostMapping
//    public Cart createCart(int customerId) {
//        carts.putIfAbsent();
//
//
//    }
}
