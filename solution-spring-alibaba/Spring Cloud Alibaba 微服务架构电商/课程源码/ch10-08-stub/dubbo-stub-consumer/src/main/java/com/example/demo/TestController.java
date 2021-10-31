package com.example.demo;

import com.example.demo.stub.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // todo 步骤2：引用服务，声明使用 stub
    @Reference(check = false, stub = "true")
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String result = "";
        // 调用服务
        result = helloService.hello(name);
        return result;
    }
}
