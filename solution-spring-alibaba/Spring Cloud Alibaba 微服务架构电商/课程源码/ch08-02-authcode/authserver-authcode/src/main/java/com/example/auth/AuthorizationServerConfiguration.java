package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 授权服务器配置
 **/
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    // 使用内存保存 token
    @Bean
    public TokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // todo 步骤4：添加客户端凭证

        // 1. 客户端ID
        // 2. 授权模式
        // 3. 作用域
        // 4. 回调地址
        // 5. 客户端安全码

        clients.inMemory()
                .withClient("client1")
                .authorizedGrantTypes("authorization_code")
                .scopes("test")
                .redirectUris("http://localhost:8080/callback")
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder()
                .encode("123456"));

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // todo 步骤5：打开 OAuth2 端点
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置tokenStore
        endpoints.authenticationManager(authenticationManager).tokenStore(memoryTokenStore())
                .userDetailsService(userDetailsService);
    }
}