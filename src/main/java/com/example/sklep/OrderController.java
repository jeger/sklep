package com.example.sklep;

import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class OrderController {

    @GetMapping(produces = "application/json")
    public @ResponseBody
    Blob getBlob() {

        Blob.builder().build();

        return null;
    }
}

@Builder
class Blob {
    private final String pole = "hello world!";
}
