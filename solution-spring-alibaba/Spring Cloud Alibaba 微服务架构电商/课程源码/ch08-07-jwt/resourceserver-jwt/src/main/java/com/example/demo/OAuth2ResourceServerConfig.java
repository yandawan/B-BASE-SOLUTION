package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

// todo 资源服务器 步骤2：加注解（开启资源服务器）
@EnableResourceServer
@Configuration
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
  // todo 资源服务器 步骤3：构建 token 转换器，设置 token 的签名密钥
  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    // 创建 JwtAccessTokenConverter
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

    // 设置签名密钥 "test-secret"
    converter.setSigningKey("test-secret");

    // 返回 converter
    return converter;
  }

  // todo 资源服务器 步骤4：创建 token 存储对象
  @Bean
  public TokenStore tokenStore() {
    // 创建 JwtTokenStore，并返回
    return new JwtTokenStore(accessTokenConverter());
  }

  // todo 资源服务器 步骤5：创建 token 服务对象，设置 token 的存储方式
  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    // 创建 DefaultTokenServices
    DefaultTokenServices tokenServices = new DefaultTokenServices();

    // DefaultTokenServices 中设置 token strore
    tokenServices.setTokenStore(tokenStore());

    // 返回 DefaultTokenServices
    return tokenServices;
  }

  // todo 资源服务器 步骤6：在配置器中指定 token 服务对象
  @Override
  public void configure(ResourceServerSecurityConfigurer config) {
    config.tokenServices(tokenServices());
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .anyRequest().authenticated().and()
            .requestMatchers().antMatchers("/api/**");
  }
}