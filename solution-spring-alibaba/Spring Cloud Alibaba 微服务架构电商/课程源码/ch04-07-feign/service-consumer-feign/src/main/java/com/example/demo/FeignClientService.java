package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-provider", fallbackFactory = FeignClientServiceFallbackFactory.class)
public interface FeignClientService {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name);
}