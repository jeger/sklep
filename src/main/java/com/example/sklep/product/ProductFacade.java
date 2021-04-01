package com.example.sklep.product;

import org.springframework.stereotype.Component;

@Component
public class ProductFacade {
    private final ProductService productService;

    public ProductFacade(ProductService productService) {
        this.productService = productService;
    }

    public Product getProductById(int productId) {
        return productService.getProductById(productId);
    }
}
