package com.example.sklep.product.converters;

import com.example.sklep.product.Product;
import com.example.sklep.product.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class PoductEntityToProductConv implements Converter<ProductEntity, Product> {
    @Override
    public Product convert(ProductEntity source) {
        return null;
    }
}
