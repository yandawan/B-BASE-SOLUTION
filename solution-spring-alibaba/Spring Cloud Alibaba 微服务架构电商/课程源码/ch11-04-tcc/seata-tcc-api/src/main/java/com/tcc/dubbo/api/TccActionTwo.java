package com.tcc.dubbo.api;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

// todo 定义接口 TccActionTwo
public interface TccActionTwo {
    @TwoPhaseBusinessAction(
            name="DubboTccActionTwo",
            commitMethod = "commit",
            rollbackMethod = "rollback"
    )
    public boolean prepare(BusinessActionContext actionContext,
                           @BusinessActionContextParameter(paramName = "b") String b);
    public boolean commit(BusinessActionContext actionContext);
    public boolean rollback(BusinessActionContext actionContext);
}
