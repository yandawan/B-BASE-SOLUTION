# 测试步骤


## 1. 启动 SkyWalking 

SkyWalking 目录下执行：

```shell script
bin/startup.sh
```

## 2. 发布 API

dubbo-skywalking-api 下执行：

```shell script
mvn clean install
```

把 dubbo-skywalking-api 安装到本地 maven 仓库。

## 3. 打包 Provider 与 Consumer 

每个服务目录下执行：

```shell script
mvn clean package -Dmaven.test.skip=true
```

## 4. 找到 SkyWalking jar 包的位置

例如我的位置：

```shell script
/Users/dys/work/springcloud-alibaba/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar
```

## 5. 启动 Provider 和 Consumer，集成 SkyWalking agent

启动 Provider：

```
java -javaagent:/Users/dys/work/springcloud-alibaba/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=dubbo-skywalking-provider \
-Dskywalking.collector.backend_service=localhost:11800 \
-jar target/dubbo-skywalking-provider-0.0.1-SNAPSHOT.jar
```

启动 Consumer：

```shell script
java -javaagent:/Users/dys/work/springcloud-alibaba/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=dubbo-skywalking-consumer \
-Dskywalking.collector.backend_service=localhost:11800 \
-jar target/dubbo-skywalking-consumer-0.0.1-SNAPSHOT.jar
```

## 6. 效果验证

访问测试接口：

[http://localhost:9091/hello?name=dubbo](http://localhost:9091/hello?name=dubbo)

查看 SkyWalking 控制台