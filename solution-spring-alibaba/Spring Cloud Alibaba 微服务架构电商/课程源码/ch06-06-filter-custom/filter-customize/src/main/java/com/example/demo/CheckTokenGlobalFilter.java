package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器 - Token 验证
 *
 * 开发步骤：
 * 1. 实现接口 GlobalFilter, Ordered
 * 2. 实现 getOrder()，返回本过滤器优先级
 * 3. 实现 filter()，定义 Token 验证逻辑
 *      获取请求中 “token” 这个header
 *      如果未设置，返回“未授权”状态码
 */

@Component
public class CheckTokenGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("---CheckTokenGlobalFilter");
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if(token == null || "".equals(token.trim())){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
