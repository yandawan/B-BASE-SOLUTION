package com.example.serviceprovider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {
    // todo 4. 配置 RestTemplate
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
