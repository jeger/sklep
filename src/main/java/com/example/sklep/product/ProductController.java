package com.example.sklep.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository repository;


    @GetMapping
    public Collection<Product> findAll() {
        return repository.findAll();
    }
}
