package com.example.demo;

import com.example.demo.dubboapi.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(check=false)
    HelloService helloService;


    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String result = "";
        result = helloService.hello(name);
        return result;
    }
}
