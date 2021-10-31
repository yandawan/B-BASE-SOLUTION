package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

// todo 第2步：加注解（开启授权服务器）
@EnableAuthorizationServer
@SpringBootApplication
public class AuthserverauthcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserverauthcodeApplication.class, args);
	}

}
