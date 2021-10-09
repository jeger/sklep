package com.example.sklep.order;

import com.example.sklep.cart.Cart;
import com.example.sklep.product.Product;
import com.example.sklep.product.dto.ProductDTO;
import com.example.sklep.product.converters.ProductToProductDTOConv;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final Map<Integer, OrderDTO> customerToOrderDTOMap = new ConcurrentHashMap<>();
    private final ProductToProductDTOConv productToProductDTOConv;

    public OrderService(ProductToProductDTOConv productToProductDTOConv) {
        this.productToProductDTOConv = productToProductDTOConv;
    }


    public OrderDTO calculateOrder(Cart cardForCustomer) {
        Map<Product, Integer> productAmountMap = cardForCustomer.getProductAmountMap();

        Map<ProductDTO, Integer> productToNumberMap =
                productAmountMap.entrySet().stream()
                        .collect(Collectors.toMap(
                                e -> productToProductDTOConv.convert(e.getKey()),
                                e -> e.getValue()
                        ));

        BigDecimal summaryPrice = new BigDecimal(0);
        for (Map.Entry<Product, Integer> productAmountEntry : productAmountMap.entrySet()) {
            summaryPrice = summaryPrice.add(productAmountEntry.getKey().getPriceUSD()
                    .multiply(new BigDecimal(productAmountEntry.getValue())));
        }

        //TODO Dodac OrderDTO do Mapy
        return OrderDTO.builder().productToNumberMap(productToNumberMap).summaryPrice(summaryPrice).build();
    }
}
