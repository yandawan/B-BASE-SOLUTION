package com.example.demo;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = "tx-consumer", topic = "topic-tx")
public class MyTxConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("receive: " + s);
    }
}
