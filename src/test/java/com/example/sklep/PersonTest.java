package com.example.sklep;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonTest {
    private static final String NAME = "John Smith";

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void personSingletonTest() {
        Person personA = applicationContext.getBean(Person.class);
        Person personB = applicationContext.getBean(Person.class);

        assertEquals(personA, personB);

        personA.setName(NAME);

        assertEquals(NAME, personB.getName());
    }

}