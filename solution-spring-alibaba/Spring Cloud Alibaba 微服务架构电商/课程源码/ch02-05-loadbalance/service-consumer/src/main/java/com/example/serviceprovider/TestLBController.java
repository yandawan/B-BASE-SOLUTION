package com.example.serviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestLBController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/testlb")
    public String testlb(@RequestParam String name){
        String  result = "";

        // todo 2. 服务调用
        result = restTemplate.getForObject("http://service-provider/hello?name=" + name, String.class);
        return result;
    }
}
