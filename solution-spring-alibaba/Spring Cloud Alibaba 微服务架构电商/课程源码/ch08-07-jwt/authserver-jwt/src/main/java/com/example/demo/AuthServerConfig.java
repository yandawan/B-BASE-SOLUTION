package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

// todo 授权服务器 步骤2：加注解（开启授权服务器）
@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // todo 授权服务器 步骤4：添加客户端凭证
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 客户端 id
        // 客户端密码
        // 作用域
        // 授权模式
        clients.inMemory()
                .withClient("client1")
                .secret(passwordEncoder.encode("123456"))
                .scopes("test")
                .authorizedGrantTypes("password");
    }

    // todo 授权服务器 步骤5：构建 token 转换器，设置 token 的签名密钥
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        // 创建 JwtAccessTokenConverter
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        // 设置签名密钥 "test-secret"
        converter.setSigningKey("test-secret");

        // 返回 converter
        return converter;
    }

    // todo 授权服务器 步骤6：创建 token 存储对象
    @Bean
    public JwtTokenStore jwtTokenStore() {
        // 创建 JwtTokenStore，并返回
        return new JwtTokenStore(accessTokenConverter());
    }

    // todo 授权服务器 步骤7：配置授权端点，指定 token 存储对象、token 转换器
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // endpoints 中设置 authenticationManager、tokenStore、accessTokenConverter
        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(accessTokenConverter());
    }

}