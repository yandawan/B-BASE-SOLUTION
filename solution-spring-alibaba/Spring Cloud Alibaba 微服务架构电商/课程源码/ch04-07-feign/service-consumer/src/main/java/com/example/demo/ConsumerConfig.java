package com.example.demo;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {
    @Bean
    @SentinelRestTemplate(
            blockHandlerClass = ExceptionUtil.class,
            blockHandler = "handleBlock",
            fallbackClass = ExceptionUtil.class,
            fallback = "handleFallback"
    )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}