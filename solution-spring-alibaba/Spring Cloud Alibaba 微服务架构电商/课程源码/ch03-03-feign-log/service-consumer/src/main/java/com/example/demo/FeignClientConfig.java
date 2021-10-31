package com.example.demo;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
