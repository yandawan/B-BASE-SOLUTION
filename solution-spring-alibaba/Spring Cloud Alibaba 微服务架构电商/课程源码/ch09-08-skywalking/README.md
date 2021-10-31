# 测试步骤

## 1. 每个服务都打成 jar 包

```shell 
$ mvn clean package -Dmaven.test.skip=true
```

## 2. jar 包方式启动每个服务，集成 SkyWalking agent

找到 SkyWalking agent jar 包的绝对路径，例如我的路径：

```
/Users/dys/Downloads/tool/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar
```

* 启动 service-gateway

```shell script
java -javaagent:/Users/dys/Downloads/tool/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar \
  -Dskywalking.agent.service_name=service-gateway \
  -Dskywalking.collector.backend_service=localhost:11800 -jar target/service-gateway-0.0.1-SNAPSHOT.jar
```

* 启动 service-provider

```shell script
java -javaagent:/Users/dys/Downloads/tool/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=service-provider \
-Dskywalking.collector.backend_service=localhost:11800 -jar target/service-provider-0.0.1-SNAPSHOT.jar
```

* 启动 service-consumer

```shell script
java -javaagent:/Users/dys/Downloads/tool/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=service-consumer \
-Dskywalking.collector.backend_service=localhost:11800 -jar target/service-consumer-0.0.1-SNAPSHOT.jar
```

## 3. 测试

1. 先启动好 SkyWalking

2. 访问测试接口

```shell script
http://localhost:9090/hi
```

3. 登录 SkyWalking 控制台查看效果

```shell script
http://localhost:8080/
```

