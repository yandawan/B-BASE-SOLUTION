package com.example.demo;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceproviderApplication.class, args);
	}

	// todo [整合 micrometer] 步骤3：监控JVM指标
	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(
			@Value("${spring.application.name}") String applicationName
	){
		return registry -> registry.config().commonTags("application", applicationName);
	}
}
