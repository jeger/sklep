package com.example.sklep.product;

import com.example.sklep.warehouse.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int productId) {
        ProductEntity productEntity = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(ProductNotFoundException.PRODUCT_MESSAGE, productId));

        return Product.builder()
                .id(productEntity.getProductId())
                .name(productEntity.getName())
                .priceUSD(productEntity.getPrice())
                .build();
    }
}
