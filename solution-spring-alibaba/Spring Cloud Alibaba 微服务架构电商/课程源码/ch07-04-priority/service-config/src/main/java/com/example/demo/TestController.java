package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${test.name}")
    private String test_name;

    @GetMapping("/test")
    public String test(){
        return test_name;
    }

    @Value("${test.priority}")
    private String test_priority;

    @GetMapping("/testpriority")
    public String testpriority(){
        return test_priority;
    }
}
