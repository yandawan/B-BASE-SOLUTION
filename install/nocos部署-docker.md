```dbn-psql
docker run -d  
--name nacos 
-p 8848:8848 
--env MODE=standalone 
--env NACOS_SERVER_IP=1.16.246.115 
nacos/nacos-server
```