package com.example.demo;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "!";
    }

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendmsg")
    public String sendmsg(Long id, String name)
    {
        rocketMQTemplate.convertAndSend("topic-test", new User(id, name));
        return "ok";
    }
}
