package com.example.sklep.order;

import com.example.sklep.cart.Cart;
import com.example.sklep.cart.CartFacade;
import org.springframework.stereotype.Component;

@Component
public class OrderFacade {
    private final OrderService orderService;
    private final CartFacade cartFacade;

    public OrderFacade(OrderService orderService, CartFacade cartFacade) {
        this.orderService = orderService;
        this.cartFacade = cartFacade;
    }


    public OrderDTO calculateOrder(int customerId) {
        Cart cardForCustomer = cartFacade.getCardForCustomer(customerId);
        return orderService.calculateOrder(cardForCustomer);
    }
}
