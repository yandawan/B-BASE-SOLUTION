package com.example.demo;

import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallback;
import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallbackRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@EnableDiscoveryClient
@SpringBootApplication
public class DubbosentinelproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubbosentinelproviderApplication.class, args);
	}

	// todo 步骤5: 注册自定义的异常处理类
	@PostConstruct
	public void setFallback(){
		DubboFallbackRegistry.setProviderFallback(new MyDubboFallback());
	}

}
