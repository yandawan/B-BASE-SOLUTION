package com.example.demo;

// todo 步骤3：创建 Dubbo Sentinel 异常处理类（实现 DubboFallback 接口）
// todo 步骤4：重写 handle 方法，自定义处理逻辑

import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallback;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;

public class MyDubboFallback implements DubboFallback {
    @Override
    public Result handle(Invoker<?> invoker, Invocation invocation, BlockException e) {
        Result result = invoker.invoke(invocation);
        result.setValue("被流控了");
        return result;
    }
}