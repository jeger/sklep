package com.example.sklep.cart;

import com.example.sklep.CartFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    //    private final CartRepository cartRepository;
    private final CartFacade cartFacade;

    private final Map<Integer, Cart> carts = new ConcurrentHashMap<>();

    @PostMapping("/{customerId}")
    public Cart createCart(@PathVariable Integer customerId) {
        //TODO Sprawdz w DB czy koszyk istnieje dla customerId

        carts.putIfAbsent(customerId, new Cart());
        return carts.get(customerId);
    }

    @PutMapping("/{customerId}")
    //TODO stworzyc DTO do productId i amountOfProduct
    public void addProduct(@PathVariable Integer customerId, @RequestBody ProductDto productDto) {
        int productId = productDto.getProductId();
        int amount = productDto.getAmount();
        cartFacade.checkProductAvailability(productId, amount);

        Cart cart = carts.get(customerId);

        if (cart == null) {
            throw new CartNotFoundException(customerId);
        }
        cart.pushProduct(productId, amount);
    }
}
