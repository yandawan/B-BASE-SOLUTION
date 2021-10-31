package com.example.demo;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientServiceFallbackFactory implements FallbackFactory<FeignClientService> {

    @Override
    public FeignClientService create(Throwable throwable) {
        return new FeignClientService() {
            @Override
            public String hello(String name) {
                System.out.println(throwable);
                return "my exception info";
            }
        };
    }
}
