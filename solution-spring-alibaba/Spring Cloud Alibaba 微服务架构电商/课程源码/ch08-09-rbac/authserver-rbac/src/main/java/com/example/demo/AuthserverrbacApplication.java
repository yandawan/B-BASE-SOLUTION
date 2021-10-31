package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
// todo （配置 mybatis）步骤2：指定 mapper 扫描位置
@MapperScan(value="com.example.demo.mapper")
public class AuthserverrbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserverrbacApplication.class, args);
	}

}
