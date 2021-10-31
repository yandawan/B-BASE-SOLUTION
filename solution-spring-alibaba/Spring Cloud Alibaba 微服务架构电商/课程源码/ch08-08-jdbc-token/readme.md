# 数据库

创建数据库，导入表、数据

修改配置文件中数据库连接信息

# 获取 token

```shell script
curl -X POST --user client1:123456 http://localhost:8080/oauth/token \
-H "accept: application/json" -H "content-type: application/x-www-form-urlencoded" \
-d "grant_type=password&username=admin&password=123456"
```

# 访问接口

启动授权码那一节中的 resource-server

```shell script
curl -X GET http://localhost:8088/user -H "authorization: Bearer 9e6355bc-cd59-4117-aa8d-88627616a1f6"
```