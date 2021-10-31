package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// todo 第2步：加注解（开启授权服务器）
@EnableAuthorizationServer
@SpringBootApplication
public class AuthserverimplicitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserverimplicitApplication.class, args);
	}

}
