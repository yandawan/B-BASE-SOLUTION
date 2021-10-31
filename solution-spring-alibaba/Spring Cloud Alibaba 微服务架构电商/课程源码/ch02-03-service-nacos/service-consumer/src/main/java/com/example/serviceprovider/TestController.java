package com.example.serviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

// todo 5. 发起服务调用

@RestController
public class TestController {
    // 引入 RestTemplate
    @Autowired
    RestTemplate restTemplate;

    // 引入 LoadBalancerClient
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        String result = "";

        // 根据服务名获取服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");

        // 发起调用
        URI uri = serviceInstance.getUri();
        result = restTemplate.getForObject(uri + "/hello?name=test", String.class);

        // 返回结果
        return result;
    }
}
