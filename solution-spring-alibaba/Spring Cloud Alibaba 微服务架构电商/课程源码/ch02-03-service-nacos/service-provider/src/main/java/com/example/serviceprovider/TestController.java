package com.example.serviceprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // todo 4. 创建测试接口
    @GetMapping("hello")
    public String hello(@RequestParam String name){
        return "hello " + name;
    }
}
