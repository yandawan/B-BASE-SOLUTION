package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// todo 步骤2：加注解，开启服务发现
@EnableDiscoveryClient

@MapperScan(value="com.example.demo.mapper")
@SpringBootApplication
public class ServicescoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicescoreApplication.class, args);
	}

}
