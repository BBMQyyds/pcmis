package com.lzy.risk;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import({
        com.lzy.common.config.DruidDataSourceConfig.class,
        com.lzy.common.config.MybatisPlusConfig.class,
        com.lzy.common.config.RedisConfig.class,
        com.lzy.common.config.RedisUtilsConfig.class,
        com.lzy.common.config.JWTConfig.class,
        com.lzy.common.config.SwaggerConfig.class,
})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@MapperScan(basePackages = "com.lzy.risk.dao")
@EnableFeignClients
@EnableAutoDataSourceProxy
@SpringBootApplication
public class RiskApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiskApplication.class, args);
    }
}
