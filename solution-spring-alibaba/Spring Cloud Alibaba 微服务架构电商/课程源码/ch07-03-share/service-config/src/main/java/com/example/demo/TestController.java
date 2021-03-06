package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${name}")
    private String name;

    @Value("${current}")
    private String current;

    @GetMapping("/envshare")
    public String envshare(){
        return "name=" + name + ", current=" + current;
    }
}
