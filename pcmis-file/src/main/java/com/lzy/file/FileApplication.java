package com.lzy.file;

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
@MapperScan(basePackages = "com.lzy.file.dao")
@EnableFeignClients
@SpringBootApplication
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }
}
