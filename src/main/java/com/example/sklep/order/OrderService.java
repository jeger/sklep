package com.example.sklep.order;

import com.example.sklep.cart.Cart;
import com.example.sklep.product.Product;
import com.example.sklep.product.ProductDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    Map<Integer, OrderDTO> customerToOrderDTOMap = new ConcurrentHashMap<>();

    public OrderDTO calculateOrder(Cart cardForCustomer) {
        Map<Product, Integer> productAmountMap = cardForCustomer.getProductAmountMap();

        Map<ProductDTO, Integer> productToNumberMap = new HashMap<>();
        productAmountMap.entrySet().forEach(productAmountEntry -> {
            Product product = productAmountEntry.getKey();
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .priceUSD(product.getPriceUSD())
                    .build();
            productToNumberMap.put(productDTO, productAmountEntry.getValue());
        });


        BigDecimal summaryPrice = new BigDecimal(0);
        for (Map.Entry<Product, Integer> productAmountEntry : productAmountMap.entrySet()) {
            summaryPrice = summaryPrice.add(productAmountEntry.getKey().getPriceUSD().multiply(new BigDecimal(productAmountEntry.getValue())));
        }

        //TODO Dodac OrderDTO do Mapy
        return OrderDTO.builder().productToNumberMap(productToNumberMap).summaryPrice(summaryPrice).build();
    }
}
