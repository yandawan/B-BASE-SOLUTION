package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义断言 QueryParams
 *
 * 关键步骤：
 * 1. 继承抽象断言工厂
 * 2. 定义断言需要的属性
 * 3. 指定属性的顺序
 * 4. 定义断言逻辑
 */
@Component
public class QueryParamsRoutePredicateFactory extends AbstractRoutePredicateFactory<QueryParamsRoutePredicateFactory.Config> {
    public QueryParamsRoutePredicateFactory() {
        super(Config.class);
    }

    /**
     * 定义断言所需属性
     */
    @Data
    @NoArgsConstructor
    public static class Config {
        String param1;
        String value1;
        String param2;
        String value2;
    }

    /**
     * 定义属性顺序
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param1","value1", "param2", "value2");
    }

    /**
     * 断言验证逻辑
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // 取得请求中的参数值
                String param1_value = serverWebExchange.getRequest().getQueryParams().getFirst(config.param1);
                String param2_value = serverWebExchange.getRequest().getQueryParams().getFirst(config.param2);

                // 验证：请求参数值不能为空
                if(param1_value == null || param2_value == null){
                    return false;
                }

                // 验证：请求参数值 == 属性配置中指定的参数值
                if(!config.getValue1().equals(param1_value) || !config.getValue2().equals(param2_value)){
                    return false;
                }

                return true;
            }
        };
    }

}
