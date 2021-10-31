package com.muke.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.muke.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/list")
    public String test() {
        return "sentinel test";
    }

    @GetMapping("/list1")
    public String test1() {
        return "sentinel list1";
    }

    @GetMapping("/test2")
    public String test2() {
        testService.test();
        return "sentinel test2";
    }
    @GetMapping("/test3")
    public String test3() {
        testService.test();
        return "sentinel test3";
    }
    @GetMapping("/fuse")
    public String fuse() throws InterruptedException {
        Thread.sleep(500);
        return "sentinel fuse";
    }

    @GetMapping("/hot")
    @SentinelResource("hot")
    public String hot(@RequestParam(value="productId",required = false)Integer productId,
                      @RequestParam(value="userId",required = false)Integer userId) throws InterruptedException {
        return "productid is "+productId+"  userid is "+userId;
    }
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        while (true) {
            String result = restTemplate.getForObject("http://localhost:9000/list/", String.class);
            System.out.println(result);
            Thread.sleep(500);
        }
    }
}
