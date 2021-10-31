
// todo 步骤1：创建 stub，实现服务接口

// 命名规则：
// 1. 包名与服务接口一致
// 2. 类名 = 接口名 + Stub

package com.example.demo.stub.api;

import com.example.demo.stub.api.HelloService;

public class HelloServiceStub implements HelloService {
    // 1. 定义一个服务接口变量
    private HelloService helloService;

    // 2. 通过构造函数注入实际的服务接口
    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String hello(String name) {
        String result = "";
        // 3. 发起调用之前的逻辑
        System.out.println("调用之前的逻辑 ……");

        // 4. 实际调用
        result = helloService.hello(name);
        System.out.println("调用的结果 : " + result);

        // 5. 调用后的逻辑
        System.out.println("调用之后的逻辑 ……");

        return result;
    }
}
