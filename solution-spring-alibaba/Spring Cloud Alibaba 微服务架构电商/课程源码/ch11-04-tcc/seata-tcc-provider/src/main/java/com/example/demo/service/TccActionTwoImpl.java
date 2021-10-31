package com.example.demo.service;

import com.tcc.dubbo.api.TccActionTwo;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.Service;

// todo 6. 实现接口 TccActionOne
@Service
public class TccActionTwoImpl implements TccActionTwo {
    @Override
    public boolean prepare(BusinessActionContext actionContext, String b) {
        System.out.println("--- TccActionTwo prepare ");
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        System.out.println("--- TccActionTwo commit ");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        System.out.println("--- TccActionTwo rollback ");
        return true;
    }
}