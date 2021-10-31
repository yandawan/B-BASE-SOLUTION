package com.example.demo;

import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.statelang.domain.StateMachineInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    // todo 5. 发起事务调用

    // 引入状态机引擎
    @Autowired
    StateMachineEngine stateMachineEngine;

    // 定义正常情况的测试接口（/testok）
    @GetMapping("/testok")
    public String testok(){
        Map<String, Object> params = new HashMap<>(3);
        String businessKey = String.valueOf(System.currentTimeMillis());
        params.put("businessKey", businessKey);
        params.put("count",10);
        params.put("amount", new Integer(100));

        StateMachineInstance stateMachineInstance = stateMachineEngine.startWithBusinessKey("reduceInventoryAndBalance", null,
                businessKey, params);
        return "XId: " + stateMachineInstance.getId();
    }

    // 定义异常情况的测试接口（/testerr）
    @GetMapping("/testerr")
    public String testerr(){
        Map<String, Object> params = new HashMap<>(3);
        String businessKey = String.valueOf(System.currentTimeMillis());
        params.put("businessKey", businessKey);
        params.put("count",10);
        params.put("amount", new Integer(-1));

        StateMachineInstance stateMachineInstance = stateMachineEngine.startWithBusinessKey("reduceInventoryAndBalance", null,
                businessKey, params);
        return "XId: " + stateMachineInstance.getId();
    }
}
