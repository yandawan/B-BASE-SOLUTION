# 获取授权码

http://localhost:8080/oauth/authorize?client_id=client1&response_type=code&scope=test

用户名密码：admin/admin

# 获取 token

```shell script
curl -X POST --user client1:123456 http://localhost:8080/oauth/token \
    -H "content-type: application/x-www-form-urlencoded" \
    -d "code=fkG8Js&grant_type=authorization_code&redirect_uri=http://localhost:8080/callback&scope=test"
```

# 请求接口

```shell script
curl -X GET http://localhost:8088/user -H "authorization: Bearer f3499c65-2be3-4e85-be74-463df6bb225b"
```
