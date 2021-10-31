# 事前准备

## Hosts

```shell
192.168.31.154	server-base # 基础服务所在的机器，nacos sentinel seata skywalking mysql
192.168.31.23	server-app	# 自己开发的服务所在机器
```

## 端口

* 基础服务

|服务|端口|
|---|---|
| nacos      | 8848 |
| seata      | 8091 |
| skywalking | 8880 |
| sentinel   | 8881 |
| mysql   | 3306 |

* 前端 	 `3000`

* 后端 6 个服务

|服务|端口|
|---|---|
| gateway | 9000 |
| admin | 9080 |
| user | 8084 |
| score | 8083 |
| order | 8082 |
|product		|8081|

## 服务接口

### 商品

* 商品列表

```shell
curl 'localhost:8081/products'
```

* 商品详情

```shell
curl 'localhost:8081/product?id=1'
```

### 订单

* 订单列表

```shell
curl 'localhost:8082/orders?username=test'
```

* 创建订单

```shell
curl --request POST 'localhost:8082/order' \
--header 'Content-Type: application/json' \
--data-raw '{
        "userName":"test",
        "amount":6698,
        "productName":"aaa2",
        "productImage":"bbb",
        "productNum":1
}'
```

### 积分

* 积分列表

```shell
curl 'localhost:8083/score?username=test'
```

* 添加积分

```shell
curl 'localhost:8083/addscore?userName=test&score=1&orderNo=23234'
```

