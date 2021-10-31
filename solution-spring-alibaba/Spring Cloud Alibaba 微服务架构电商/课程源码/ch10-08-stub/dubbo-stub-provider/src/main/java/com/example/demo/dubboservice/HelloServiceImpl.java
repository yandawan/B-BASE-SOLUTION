package com.example.demo.dubboservice;

import com.example.demo.stub.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello "+name;
    }
}
