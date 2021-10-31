package com.example.demo;

import com.tcc.dubbo.api.TccActionOne;
import com.tcc.dubbo.api.TccActionTwo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TccActionOne tccActionOne;

    @Autowired
    TccActionTwo tccActionTwo;

    // todo 6. 发起事务调用，添加全局事务注解（@GlobalTransactional）
    @GetMapping("/testok")
    @GlobalTransactional
    public void testok(){
        tccActionOne.prepare(null, 1);
        tccActionTwo.prepare(null, "two");
    }

    @GetMapping("/testerr")
    @GlobalTransactional
    public void testerr(){
        tccActionOne.prepare(null, 1);
        tccActionTwo.prepare(null, "two");

        throw  new RuntimeException("模拟异常");
    }
}
