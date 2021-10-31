package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {
    String INPUT = "my-input";

    @Input(INPUT)
    SubscribableChannel input();
}
