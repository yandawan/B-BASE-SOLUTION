package com.tcc.dubbo.api;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

// todo 定义接口 TccActionOne
public interface TccActionOne {
    @TwoPhaseBusinessAction(
            name="DubboTccActionOne",
            commitMethod = "commit",
            rollbackMethod = "rollback"
    )
    public boolean prepare(BusinessActionContext actionContext,
                           @BusinessActionContextParameter(paramName = "a") int a);
    public boolean commit(BusinessActionContext actionContext);
    public boolean rollback(BusinessActionContext actionContext);
}
