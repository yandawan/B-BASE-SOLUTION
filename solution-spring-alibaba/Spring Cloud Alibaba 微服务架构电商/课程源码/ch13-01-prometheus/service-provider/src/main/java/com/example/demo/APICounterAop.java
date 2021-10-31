package com.example.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Aspect
public class APICounterAop {
    @Pointcut("execution(public * com.example.demo.*.*(..))")
    public void pointCut() {
    }

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Autowired
    MeterRegistry registry;
    private Counter counter;

    @PostConstruct
    private void init() {
        // 启动后初始化计数器
        counter = registry.counter("requests_total", "status", "success");
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("do before");
        counter.increment(); // 收到请求后计数器+1
    }

    @AfterReturning(returning = "returnVal", pointcut = "pointCut()")
    public void doAfterReturning(Object returnVal) {
        System.out.println("do after");
    }
}