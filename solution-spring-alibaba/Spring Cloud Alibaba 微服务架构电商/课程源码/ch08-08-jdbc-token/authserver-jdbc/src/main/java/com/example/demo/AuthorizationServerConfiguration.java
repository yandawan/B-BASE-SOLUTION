package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

// todo 步骤2：加注解（开启授权服务器）
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    // todo 步骤5：创建数据源 DataSource 对象
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        // 创建 DataSource 并返回
        return DataSourceBuilder.create().build();
    }

    // todo 步骤6：创建 JDBC 方式的 token 存储对象
    @Bean
    public TokenStore jdbcTokenStore() {
        // 创建 JdbcTokenStore，指定 DataSource，返回
        return new JdbcTokenStore(dataSource());
    }

    // todo 步骤7：创建客户端凭证的服务对象，使用 JDBC 方式
    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        // 创建 JdbcClientDetailsService，指定 DataSource，返回
        return new JdbcClientDetailsService(dataSource());
    }

    // todo 步骤8：配置客户端凭证的服务对象
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用 JdbcClientDetailsService
        clients.withClientDetails(jdbcClientDetailsService());
    }

    // todo 步骤9：配置授权端点，指定授权管理器、jdbc 方式的 token 存储、用户详情服务
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 为 endpoints 指定 authenticationManager、JdbcTokenStore、userDetailsService
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(jdbcTokenStore())
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

}