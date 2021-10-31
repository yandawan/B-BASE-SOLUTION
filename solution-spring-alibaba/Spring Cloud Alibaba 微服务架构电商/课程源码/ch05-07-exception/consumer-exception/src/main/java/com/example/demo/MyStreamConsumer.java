package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyStreamConsumer {
    @StreamListener(Sink.INPUT)
    public void receive(String msg){
        log.info("msg: {}", msg);
        throw new IllegalArgumentException("param error");
    }

    @StreamListener("errorChannel")
    public void handleError(ErrorMessage errorMessage){
        log.error("全局异常. errorMsg: {}", errorMessage);
    }

//    @ServiceActivator(
//            inputChannel = "stream-exception.group-exception.errors"
//    )
//    public void handleError(ErrorMessage errorMessage){
//        log.error("局部异常. errorMsg: {}", errorMessage);
//    }


}
