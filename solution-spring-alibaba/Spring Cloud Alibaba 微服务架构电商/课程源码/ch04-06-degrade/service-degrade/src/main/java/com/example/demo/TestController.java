package com.example.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/degrade-rt")
    public String test_degrade_rt() throws InterruptedException {
        Thread.sleep(200);
        return "ok";
    }

    @GetMapping("/degrade-rate")
    public String test_degrade_rate() throws Exception{
        throw new Exception("test_degrade_rate");
    }

    @GetMapping("/degrade-num")
    public String test_degrade_num() throws Exception{
        throw new Exception("test_degrade_num");
    }
}
