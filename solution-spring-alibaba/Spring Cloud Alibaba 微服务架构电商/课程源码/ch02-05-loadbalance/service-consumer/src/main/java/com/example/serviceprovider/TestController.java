package com.example.serviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("hello")
    public String hello(@RequestParam String name){
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/hello?name=test", String.class);
    }
}
