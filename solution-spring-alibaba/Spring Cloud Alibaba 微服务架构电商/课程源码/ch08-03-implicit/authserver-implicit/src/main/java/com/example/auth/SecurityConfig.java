package com.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// 开启安全验证
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        // todo 第3步：添加测试用户(用户名：admin，密码：admin)

        // 1. 构建内存模式的用户管理器
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // 2. 添加用户（用户名、密码、角色）
        manager.createUser(
                User.withUsername("admin")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder()
                .encode("admin"))
                .authorities("USER").build()
        );

        // 3. 返回用户管理器
        return manager;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}