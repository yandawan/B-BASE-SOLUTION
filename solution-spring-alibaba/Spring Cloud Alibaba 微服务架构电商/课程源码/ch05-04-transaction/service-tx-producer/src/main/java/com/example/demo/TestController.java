package com.example.demo;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("/tx/test")
    public String sentMsg(String msg){
        rocketMQTemplate.sendMessageInTransaction("topic-tx",
                MessageBuilder.withPayload(msg).build(), null);
        return null;
    }
}
