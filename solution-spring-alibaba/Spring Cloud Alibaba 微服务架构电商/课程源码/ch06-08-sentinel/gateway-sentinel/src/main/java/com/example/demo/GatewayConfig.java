package com.example.demo;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class GatewayConfig {
    @PostConstruct
    public void customizeApi() {
        Set<ApiDefinition> definitions = new HashSet<>();

        ApiDefinition apiDefinition = new ApiDefinition("customized_api")
                .setPredicateItems(new HashSet<ApiPredicateItem>() {
                    {
                        add(new ApiPathPredicateItem().setPattern("/article/**")
                                .setMatchStrategy(SentinelGatewayConstants.PARAM_MATCH_STRATEGY_PREFIX));
                        add(new ApiPathPredicateItem().setPattern("/product/**")
                                .setMatchStrategy(SentinelGatewayConstants.PARAM_MATCH_STRATEGY_PREFIX));
                    }
                });
        definitions.add(apiDefinition);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }
}
