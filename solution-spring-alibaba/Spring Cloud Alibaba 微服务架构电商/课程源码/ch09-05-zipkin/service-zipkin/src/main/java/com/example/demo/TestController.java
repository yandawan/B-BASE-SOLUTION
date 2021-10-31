package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi() {
        String result = restTemplate.getForObject("http://localhost:8081/hi", String.class);
        log.info("result: {}" + result);
        return result;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "!";
    }
}
