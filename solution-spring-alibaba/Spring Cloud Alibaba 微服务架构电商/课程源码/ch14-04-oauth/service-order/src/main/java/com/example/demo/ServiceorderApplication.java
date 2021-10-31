package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

// todo [资源请求] 2. 开启资源服务器
@EnableResourceServer

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value="com.example.demo.mapper")
public class ServiceorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceorderApplication.class, args);
	}

}
