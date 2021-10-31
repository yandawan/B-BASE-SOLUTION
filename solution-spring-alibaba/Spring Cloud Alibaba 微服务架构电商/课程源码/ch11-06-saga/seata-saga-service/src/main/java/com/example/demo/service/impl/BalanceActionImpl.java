package com.example.demo.service.impl;

import com.example.demo.service.BalanceAction;
import org.springframework.stereotype.Service;

// todo 2. 实现业务接口 BalanceAction
@Service
public class BalanceActionImpl implements BalanceAction {
    @Override
    public boolean reduce(String businessKey, Integer amount) {
        if(amount == -1){
            throw new RuntimeException("模拟余额扣减故障");
        }
        System.out.println("=== 扣减余额 OK");
        return true;
    }

    @Override
    public boolean compensateReduce(String businessKey) {
        System.out.println("=== 补偿余额 OK");
        return true;
    }
}