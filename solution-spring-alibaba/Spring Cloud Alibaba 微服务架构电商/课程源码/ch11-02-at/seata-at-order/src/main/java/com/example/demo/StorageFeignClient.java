package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="storage-service", url = "http://localhost:8081")
public interface StorageFeignClient {
    @GetMapping("/hello")
    public String hello(@RequestParam String name);

    @GetMapping("/deduct")
    Boolean deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
