package com.example.sklep.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CartControllerIT {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test1() {
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity("/cart/1", null, null);

        assertThat(objectResponseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
