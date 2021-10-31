package com.example.demo.config;

import com.example.demo.service.BalanceAction;
import com.example.demo.service.InventoryAction;
import com.example.demo.service.impl.BalanceActionImpl;
import com.example.demo.service.impl.InventoryActionImpl;
import io.seata.saga.engine.config.DbStateMachineConfig;
import io.seata.saga.engine.impl.ProcessCtrlStateMachineEngine;
import io.seata.saga.rm.StateMachineEngineHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// todo 4. 配置类
@Configuration
public class MyConfig {
    // 定义变量 - 状态机描述 json 文件 Resource
    @Value("classpath:statelang/reduce_inventory_and_balance.json")
    private Resource resource;

    // 定义Bean - 数据源 DataSource
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:seata_saga;INIT=RUNSCRIPT FROM 'classpath:sql/h2_init.sql'");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    // 定义Bean - 状态机数据库配置 DbStateMachineConfig
    @Bean
    public DbStateMachineConfig dbStateMachineConfig(DataSource dataSource){
        DbStateMachineConfig dbStateMachineConfig = new DbStateMachineConfig();
        dbStateMachineConfig.setDataSource(dataSource);
        dbStateMachineConfig.setResources(new Resource[]{resource});
        dbStateMachineConfig.setApplicationId("seata-saga-service");
        dbStateMachineConfig.setTxServiceGroup("my_test_tx_group");
        return dbStateMachineConfig;
    }

    // 定义Bean - 流程控制状态机引擎 ProcessCtrlStateMachineEngine
    @Bean
    public ProcessCtrlStateMachineEngine stateMachineEngine(DbStateMachineConfig stateMachineConfig){
        ProcessCtrlStateMachineEngine processCtrlStateMachineEngine = new ProcessCtrlStateMachineEngine();
        processCtrlStateMachineEngine.setStateMachineConfig(stateMachineConfig);
        return processCtrlStateMachineEngine;
    }

    // 定义Bean - 状态机引擎控制器 StateMachineEngineHolder
    @Bean
    public StateMachineEngineHolder stateMachineEngineHolder(ProcessCtrlStateMachineEngine stateMachineEngine){
        StateMachineEngineHolder stateMachineEngineHolder = new StateMachineEngineHolder();
        stateMachineEngineHolder.setStateMachineEngine(stateMachineEngine);
        return stateMachineEngineHolder;
    }

    // 定义Bean - 业务服务 - 库存
    @Bean
    public InventoryAction inventoryAction(){
        return new InventoryActionImpl();
    }

    // 定义Bean - 业务服务 - 金额
    @Bean
    public BalanceAction balanceAction(){
        return new BalanceActionImpl();
    }

}
