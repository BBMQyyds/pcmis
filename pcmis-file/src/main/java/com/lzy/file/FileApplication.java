package com.lzy.file;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

// 导入多个配置类，用于配置数据源、MyBatis-Plus、Redis、JWT、Swagger等
@Import({
        com.lzy.common.config.DruidDataSourceConfig.class,
        com.lzy.common.config.MybatisPlusConfig.class,
        com.lzy.common.config.RedisConfig.class,
        com.lzy.common.config.RedisUtilsConfig.class,
        com.lzy.common.config.JWTConfig.class,
        com.lzy.common.config.SwaggerConfig.class,
})
// 注释掉以下行以排除自动配置的数据源，以便使用自定义数据源配置
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
// 扫描指定包下的Mapper接口，用于MyBatis-Plus的Mapper扫描
@MapperScan(basePackages = "com.lzy.file.dao")
// 启用Feign客户端，用于声明式REST调用
@EnableFeignClients
// 启用数据源代理自动配置，可能用于日志记录、监控等
@EnableAutoDataSourceProxy
// 标记为Spring Boot应用的主类
@SpringBootApplication
public class FileApplication {
    // 主函数，应用的入口点
    public static void main(String[] args) {
        // 运行Spring Boot应用
        SpringApplication.run(FileApplication.class, args);
    }
}
