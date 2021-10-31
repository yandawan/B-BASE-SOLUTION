package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "!";
    }

    @GetMapping("/test/head")
    public String testGatewayHead(HttpServletRequest request, HttpServletResponse response){
        String head=request.getHeader("X-Request-red");
        return "X-Request-red : "+head;
    }

    @Value("${server.port}")
    Integer port;

    @GetMapping("/test/lb")
    public String testLB(){
        return "port: " + port;
    }
}
