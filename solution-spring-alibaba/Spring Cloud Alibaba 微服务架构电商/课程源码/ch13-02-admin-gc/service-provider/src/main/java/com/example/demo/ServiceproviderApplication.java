package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// todo 步骤2：加注解，开启服务发现
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceproviderApplication.class, args);
	}

}
