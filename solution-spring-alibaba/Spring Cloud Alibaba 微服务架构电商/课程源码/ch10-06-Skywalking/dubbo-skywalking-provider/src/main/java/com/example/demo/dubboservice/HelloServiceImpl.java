package com.example.demo.dubboservice;


// 1. 添加 dubbo 的 @Service 注解，注意：@Service 是使用 Dubbo 的，不是 Spring 的
// 2. 实现 HelloService 接口

import com.example.skywalking.dubboapi.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
