package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 开发步骤：
 * 1. 继承 AbstractNameValueGatewayFilterFactory
 * 2. 实现 apply()
 * 3. 进入时设置当前时间
 * 4. 返回时计算总耗时
 */
@Component
public class AddDebugGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            System.out.println("---AddDebugGatewayFilterFactory");
            exchange.getAttributes().put("time_start", System.currentTimeMillis());

            return chain.filter(exchange).then(
                    Mono.fromRunnable(
                            () -> {
                                Long time_start = exchange.getAttribute("time_start");
                                Long time_end = System.currentTimeMillis();
                                System.out.println("共耗时：" + (time_end -time_start) + "ms");
                            }
                    )
            );
        };
    }
}
