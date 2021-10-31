package com.example.demo;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = "group-consumer", topic = "topic-test")
public class MyMQConsumer implements RocketMQListener<User> {
    @Override
    public void onMessage(User user) {
        System.out.println(user);
    }
}
