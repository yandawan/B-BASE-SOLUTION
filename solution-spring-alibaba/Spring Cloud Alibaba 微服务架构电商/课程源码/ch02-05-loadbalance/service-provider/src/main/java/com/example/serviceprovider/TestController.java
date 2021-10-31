package com.example.serviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // todo 1. 使用配置的服务端口号
    @Value("${server.port}")
    Integer port;

    @GetMapping("hello")
    public String hello(@RequestParam String name){
        return "hello " + name + " " + port;
    }
}
