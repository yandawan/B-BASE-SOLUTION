package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.example"}, exclude = DataSourceAutoConfiguration.class)
public class SeataatorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataatorderApplication.class, args);
	}

}
