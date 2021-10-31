package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class SleuthThreadConfig {
    // todo Thread 步骤1：定义可跟踪的线程服务
    @Autowired
    BeanFactory beanFactory;

    @Bean
    public ExecutorService executorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        return new TraceableExecutorService(this.beanFactory, executorService);
    }
}
