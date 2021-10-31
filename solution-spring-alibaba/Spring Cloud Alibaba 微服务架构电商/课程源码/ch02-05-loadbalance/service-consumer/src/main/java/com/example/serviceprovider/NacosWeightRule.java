package com.example.serviceprovider;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;

public class NacosWeightRule extends AbstractLoadBalancerRule {
    // 引入 NacosDiscoveryProperties
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    // 重写 choose 方法
    @Override
    public Server choose(Object o) {
        // 获取服务提供者的名字
        // 拿到 nacos 的命名服务对象
        // 通过 nacos 的命名服务根据权重获取实例
        // 封装 server 对象，返回

        BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        String name = loadBalancer.getName();

        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        try {
            Instance instance = namingService.selectOneHealthyInstance(name);
            return new NacosServer(instance);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
