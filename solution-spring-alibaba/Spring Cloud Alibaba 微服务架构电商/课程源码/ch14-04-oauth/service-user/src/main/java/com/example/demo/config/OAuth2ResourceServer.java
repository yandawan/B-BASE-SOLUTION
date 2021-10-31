package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

// todo [退出] 2. 开启资源服务器
@EnableResourceServer
@Configuration
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

    // todo [退出] 3. 资源服务器配置，保护退出接口
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest()
                .authenticated().and()
                .requestMatchers().antMatchers("/api/**");
    }

}