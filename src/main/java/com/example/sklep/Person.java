package com.example.sklep;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Person {
    @Setter
    @Getter
    private String name;
}
