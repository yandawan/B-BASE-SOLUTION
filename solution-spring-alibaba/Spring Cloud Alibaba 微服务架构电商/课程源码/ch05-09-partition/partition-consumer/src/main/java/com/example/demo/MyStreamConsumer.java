package com.example.demo;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MyStreamConsumer {
    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        System.out.println("receive: " + message.getPayload() );

    }
}