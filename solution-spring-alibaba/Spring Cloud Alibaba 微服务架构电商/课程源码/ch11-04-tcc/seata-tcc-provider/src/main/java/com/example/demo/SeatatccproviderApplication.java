package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// todo 2. 加注解，开启服务发现（@EnableDiscoveryClient）
@EnableDiscoveryClient
@SpringBootApplication
public class SeatatccproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatatccproviderApplication.class, args);
	}

}
