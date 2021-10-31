package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {

    // todo RestTemplate 步骤2：引入 RestTemplate
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/helloByRestTemplate")
    public String helloByRestTemplate() {
        String result = "";
        // todo RestTemplate 步骤3：RestTemplate 服务调用（http://localhost:8081/hello）
        result = restTemplate.getForObject("http://localhost:8081/hello", String.class);

        // todo RestTemplate 步骤4: 输出日志
        log.info("helloByRestTemplate result: {}", result);

        return result;
    }

}
