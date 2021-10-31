package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @Autowired
    FeignClientService feignClientService;

    @GetMapping("hello_feign")
    public String hello_feign(String name){
        return feignClientService.hello(name);
    }
}
