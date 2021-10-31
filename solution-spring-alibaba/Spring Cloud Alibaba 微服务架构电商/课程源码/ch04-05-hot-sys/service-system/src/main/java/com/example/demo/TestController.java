package com.example.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/test-rt")
    public String testRT() throws InterruptedException {
        Thread.sleep(200);
        return "test rt";
    }

    @GetMapping("/test-qps-1")
    public String testQps1(){
        return "test qps 1";
    }
    @GetMapping("/test-qps-2")
    public String testQps2(){
        return "test qps 2";
    }
    @GetMapping("/test-qps-3")
    public String testQps3(){
        return "test qps 3";
    }
}
