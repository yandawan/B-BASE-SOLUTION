package com.example.demo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class MyStreamConsumer {
    @StreamListener(value= Sink.INPUT,
        condition = "headers['test-header']=='my test'")
    public void receive(String msg){
        System.out.println("receive: " + msg);
    }

    @StreamListener(value= MySink.INPUT)
    public void receive_myinput(String msg){
        System.out.println("receive: " + msg);
    }
}
