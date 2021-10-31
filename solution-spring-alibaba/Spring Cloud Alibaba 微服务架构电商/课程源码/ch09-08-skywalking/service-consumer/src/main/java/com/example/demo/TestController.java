package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi() {
        return "consumer hi: " + restTemplate.getForObject("http://localhost:9092/hi", String.class);
    }

}
