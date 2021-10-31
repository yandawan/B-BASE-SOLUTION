package com.example.demo.service.impl;

import com.example.demo.service.InventoryAction;
import org.springframework.stereotype.Service;

// todo 3. 实现业务接口 InventoryAction
@Service
public class InventoryActionImpl implements InventoryAction {
    @Override
    public boolean reduce(String businessKey, int count) {
        System.out.println("=== 扣减库存 OK");
        return true;
    }

    @Override
    public boolean compensateReduce(String businessKey) {
        System.out.println("=== 补偿库存 OK");
        return true;
    }
}