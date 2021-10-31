package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
@RestController
public class ThreadController {
    @Autowired
    HelloService helloService;

    // todo Thread 步骤2：引用可跟踪的线程服务
    @Autowired
    ExecutorService executorService;

    @GetMapping("/helloByThread")
    public String helloByNewThread() throws ExecutionException, InterruptedException {
        String result = "";

        // todo Thread 步骤3: 开启线程(线程内部调用远程服务，打印一条日志)
        Future<String> future = executorService.submit(() -> {
            log.info("in thread");
            return helloService.sayHello();
        });

        // todo Thread 步骤4: 线程外打印一条日志
        result = (String) future.get();
        log.info("thread result: {}", result);

        return result;
    }
}
