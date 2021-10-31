package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableDiscoveryClient

@MapperScan(value="com.example.demo.mapper")
@SpringBootApplication
public class ServicescoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicescoreApplication.class, args);
	}

}
