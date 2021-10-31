package com.example.demo;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@EnableFeignClients
@RestController
public class TestController {
    @Autowired
    StorageFeignClient storageFeignClient;

    @Resource
    private OrderService orderService;

    // todo 步骤6：添加全局事务注解（@GlobalTransactional）
    @GlobalTransactional
    @GetMapping("/order")
    public String hi(String code, Integer count) {
        // 下订单
        orderService.placeOrder("1", code ,count);
        // 减库存
        storageFeignClient.deduct(code, count);
        return "ok";
    }

}
