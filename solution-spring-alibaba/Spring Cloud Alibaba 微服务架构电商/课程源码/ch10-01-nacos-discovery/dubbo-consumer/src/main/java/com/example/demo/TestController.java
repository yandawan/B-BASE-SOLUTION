package com.example.demo;

import com.example.demo.dubboapi.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // todo 步骤4：引用服务接口（使用 dubbo 的 @Reference 注解）
    @Reference(check=false)
    HelloService helloService;


    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String result = "";
        // todo 步骤5：调用服务接口
        result = helloService.hello(name);
        return result;
    }
}
