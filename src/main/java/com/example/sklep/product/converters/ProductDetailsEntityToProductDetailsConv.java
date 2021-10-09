package com.example.sklep.product.converters;

import com.example.sklep.product.ProductDetails;
import com.example.sklep.product.ProductDetailsEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsEntityToProductDetails implements Converter<ProductDetailsEntity, ProductDetails> {
    @Override
    public ProductDetails convert(ProductDetailsEntity source) {
        return ProductDetails.builder()
                .id(source.getProductDetailsId())
                .description(source.getDescription())
                .imagesPaths(source.getImagesPaths())
                .build();
    }
}
