package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

// todo Feign 步骤1：创建 FeignClient 接口
@FeignClient(name = "sleuth-provider", url = "localhost:8081")
public interface HelloService {
    @RequestMapping("/hello")
    String sayHello();
}
