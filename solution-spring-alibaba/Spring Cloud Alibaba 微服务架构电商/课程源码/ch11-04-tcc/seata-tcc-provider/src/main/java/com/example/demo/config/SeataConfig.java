package com.example.demo.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// todo 7. seata 配置类 - 配置全局事务扫描器
@Configuration
public class SeataConfig {
    // 配置全局事务扫描器
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("seata-tcc-provider", "my_test_tx_group");
    }
}
