package com.example.sklep.cart;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    //    private final CartRepository cartRepository;
    private final CartFacade cartFacade;


    @PostMapping("/{customerId}")
    public void createCart(@PathVariable Integer customerId) {
        //TODO Sprawdz w DB czy koszyk istnieje dla customerId
        cartFacade.createCart(customerId);
    }

    @PutMapping("/{customerId}")
    public void addProduct(@PathVariable Integer customerId, @RequestBody ProductAddedToCartDTO productAddedToCartDTO) {
        cartFacade.addProductToCart(customerId, productAddedToCartDTO);
    }
}
