package com.example.demo.service;

import com.tcc.dubbo.api.TccActionOne;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.Service;

// todo 5. 实现接口 TccActionOne
@Service
public class TccActionOneImpl implements TccActionOne {
    @Override
    public boolean prepare(BusinessActionContext actionContext, int a) {
        System.out.println("---TccActionOne prepare ");
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        System.out.println("---TccActionOne commit ");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        System.out.println("---TccActionOne rollback ");
        return true;
    }
}
