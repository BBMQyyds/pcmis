package com.lzy.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import({
        com.lzy.common.config.DruidDataSourceConfig.class,
        com.lzy.common.config.MybatisPlusConfig.class,
        com.lzy.common.config.RedisConfig.class,
})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@MapperScan(basePackages = "com.lzy.project.dao")
@EnableFeignClients
@SpringBootApplication
public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
}
