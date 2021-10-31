package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// todo 步骤2：加注解，开启服务发现
@EnableDiscoveryClient

@SpringBootApplication
@MapperScan(value="com.example.demo.mapper")
public class ServiceuserApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceuserApplication.class, args);
	}
}
