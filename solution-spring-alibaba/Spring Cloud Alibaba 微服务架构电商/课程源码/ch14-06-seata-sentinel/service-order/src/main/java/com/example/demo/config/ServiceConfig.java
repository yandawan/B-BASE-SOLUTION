package com.example.demo.config;

import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * 定义 DataSourceProxy，SqlSessionFactory，SqlSessionTemplate，DataSourceTransactionManager
 * SqlSessionTemplate 使用 SqlSessionFactory
 * SqlSessionFactory 使用 DataSourceProxy
 * DataSourceProxy 是 seata 对 DataSource 的封装
 * DataSourceTransactionManager 使用 DataSourceProxy
 */
@Configuration
public class ServiceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // 1. DataSourceProxy
    @Bean
    @Primary
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }

    // 2. DataSourceTransactionManager
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSourceProxy dataSourceProxy){
        return new DataSourceTransactionManager(dataSourceProxy);
    }

    // 3. SqlSessionFactory
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceProxy);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:/mapper/*.xml")
        );
        factoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return factoryBean.getObject();
    }

    // 4. SqlSessionTemplate
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
