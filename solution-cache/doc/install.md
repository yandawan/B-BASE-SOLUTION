# redis 集群搭建

```concept
docker stop redis-node1 redis-node2 redis-node3; \
docker rm redis-node1 redis-node2 redis-node3;  \
rm -rf /Users/macuser/Desktop/java/redis/node*;
```

```concept
docker create --name redis-node1  -v /Users/macuser/Desktop/java/redis/node1:/data -e REDIS_PORT=7001 -p 7001:7001 -p 17001:17001  redis:5.0.5 --cluster-enabled yes --cluster-config-file nodes-node-1.conf;  \
docker create --name redis-node2  -v /Users/macuser/Desktop/java/redis/node2:/data -e REDIS_PORT=7002 -p 7002:7002 -p 17002:17002 redis:5.0.5 --cluster-enabled yes --cluster-config-file nodes-node-2.conf; \
docker create --name redis-node3  -v /Users/macuser/Desktop/java/redis/node3:/data -e REDIS_PORT=7003 -p 7003:7003 -p 17003:17003 redis:5.0.5 --cluster-enabled yes --cluster-config-file nodes-node-3.conf; \
chmod -R 777 /Users/macuser/Desktop/java; \
docker start redis-node1 redis-node2 redis-node3; \
docker exec -it redis-node1 /bin/bash;
```

```concept
文件夹授权:
chmod -R 777 /Users/macuser/Desktop/java


docker start redis-node1 redis-node2 redis-node3
```

```concept
docker inspect redis-node1 -> 172.17.0.4
docker inspect redis-node2 -> 172.17.0.5
docker inspect redis-node3 -> 172.17.0.6
```

```concept
# 这里以进入 node1 为例
docker exec -it redis-node1 /bin/bash

# 接着执行组建集群命令
redis-cli --cluster create 192.168.0.118:7001 192.168.0.118:7002 192.168.0.118:7003 --cluster-replicas 0
```


docker run -p 6400:6379 \
--name redis1 \
-d --restart=always \
--privileged=true \
redis:latest \
redis-server --appendonly yes