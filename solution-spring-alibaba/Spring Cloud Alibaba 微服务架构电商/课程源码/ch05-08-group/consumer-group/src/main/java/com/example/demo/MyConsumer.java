package com.example.demo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class MyConsumer {
    @StreamListener(Sink.INPUT)
    public void receive(String msg)
    {
        System.out.println("msg: " + msg);
    }
}
