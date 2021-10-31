package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {
    // todo RestTemplate 步骤1：创建 RestTemplate Bean
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
