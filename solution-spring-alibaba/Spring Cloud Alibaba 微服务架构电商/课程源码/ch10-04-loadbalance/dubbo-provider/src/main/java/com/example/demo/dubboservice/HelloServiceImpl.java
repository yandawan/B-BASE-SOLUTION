package com.example.demo.dubboservice;

import com.example.demo.dubboapi.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class HelloServiceImpl implements HelloService {
    // todo 步骤1：获取服务实例端口，输出
    @Value("${server.port}")
    private String port;

    @Override
    public String hello(String name) {
        return "hello " + name + ", " + port;
    }
}
