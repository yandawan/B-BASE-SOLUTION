package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FeignController {

    // todo Feign 步骤2：引入 FeignClient：HelloService
    @Autowired
    HelloService helloService;

    @GetMapping("/helloByFeign")
    public String helloByFeign(){
        String result = "";

        // todo Feign 步骤3: Feign 服务调用
        result = helloService.sayHello();

        // todo Feign 步骤4: 输出日志
        log.info("helloByFeign result: {}", result);

        return result;
    }

}
