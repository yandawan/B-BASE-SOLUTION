package com.example.demo;

import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;
import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignClientOkHttpConfiguration {

    @Bean
    public OkHttpClient okHttpClient() {
        // 配置项：
        // 1.连接超时时间
        // 2.响应超时时间
        // 3.写超时时间
        // 4.自动重连
        // 5.配置连接池
        // 6.添加日志拦截器
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool())
                .addInterceptor(new LogInterceptor())
                .build();
    }


}