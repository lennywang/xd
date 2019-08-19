package com.xdclass.redis;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.sql.DataSource;
import java.lang.invoke.MethodHandles;

/**
 *
 **/
@Configuration
@MapperScan("com.xdclass.redis.mapper")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 50)
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("spring.datasource.url")
    private String dbUrl;

    @Value("spring.datasource.type")
    private String dbType;

    @Value("spring.datasource.username")
    private String username;

    @Value("spring.datasource.password")
    private String password;

    @Value("spring.datasource.driver-class-name")
    private String driverClassName;

    @Bean(name = "dataSource")
    @Primary
    public DataSource getDataSource()
    {
        DruidDataSource druidDataSource = new DruidDataSource();
        try {

            druidDataSource.setUrl(this.dbUrl);
            druidDataSource.setDbType(dbType);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setDriverClassName(driverClassName);
        }catch (Exception e){
            logger.error("druid configuration initialization filter",e);
        }
        return druidDataSource;
    }
}
