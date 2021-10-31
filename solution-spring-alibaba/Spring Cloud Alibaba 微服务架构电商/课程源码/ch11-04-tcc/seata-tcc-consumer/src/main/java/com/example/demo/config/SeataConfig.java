package com.example.demo.config;

import com.tcc.dubbo.api.TccActionOne;
import com.tcc.dubbo.api.TccActionTwo;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// todo 5. Seata 配置类 - 配置全局事务扫描器、dubbo 接口
@Configuration
public class SeataConfig {
    // 1. 配置全局事务扫描器
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("seata-tcc-consumer", "my_test_tx_group");
    }

    // 2. 配置 ReferenceBean<TccActionOne>
    @Bean
    ReferenceBean<TccActionOne> tccActionOneReferenceBean(){
        ReferenceBean<TccActionOne> tccActionOneReferenceBean = new ReferenceBean<>();
        tccActionOneReferenceBean.setInterface(TccActionOne.class);
        tccActionOneReferenceBean.setCheck(false);
        tccActionOneReferenceBean.setTimeout(3000);
        tccActionOneReferenceBean.setLazy(true);
        return tccActionOneReferenceBean;
    }

    // 3. 配置 ReferenceBean<TccActionTwo>
    @Bean
    ReferenceBean<TccActionTwo> tccActionTwoReferenceBean(){
        ReferenceBean<TccActionTwo> tccActionTwoReferenceBean = new ReferenceBean<>();
        tccActionTwoReferenceBean.setInterface(TccActionTwo.class);
        tccActionTwoReferenceBean.setCheck(false);
        tccActionTwoReferenceBean.setTimeout(3000);
        tccActionTwoReferenceBean.setLazy(true);
        return tccActionTwoReferenceBean;
    }
}