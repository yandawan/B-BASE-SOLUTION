package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value="com.example.demo.mapper")
public class ServiceuserApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceuserApplication.class, args);
	}
}
