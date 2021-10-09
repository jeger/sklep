package com.example.sklep.product.converters;

import com.example.sklep.product.ProductDTO;
import com.example.sklep.product.entites.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ProductEntityToProductDTOconv implements Converter<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity source) {
        return null;
    }
}
