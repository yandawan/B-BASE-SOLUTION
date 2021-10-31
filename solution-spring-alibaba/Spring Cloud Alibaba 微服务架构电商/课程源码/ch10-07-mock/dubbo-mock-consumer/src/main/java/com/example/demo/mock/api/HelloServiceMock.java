package com.example.demo.mock.api;

// todo 步骤1：创建 mock 伪装

public class HelloServiceMock implements HelloService {
    @Override
    public String hello(String name) {
        return "mock hello " + name;
    }
}