package com.lzy.project;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

// 导入多个配置类，用于项目初始化时加载相关配置
@Import({
        com.lzy.common.config.DruidDataSourceConfig.class, // Druid数据源配置
        com.lzy.common.config.MybatisPlusConfig.class, // MyBatis Plus配置
        com.lzy.common.config.RedisConfig.class, // Redis配置
        com.lzy.common.config.RedisUtilsConfig.class, // Redis工具类配置
        com.lzy.common.config.JWTConfig.class, // JWT配置
        com.lzy.common.config.SwaggerConfig.class // Swagger配置
})
// 使用Spring Boot应用启动注解，排除自动配置的数据源以使用自定义配置
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
// 扫描指定包下的Mapper接口，用于MyBatis Plus的Mapper扫描
@MapperScan(basePackages = "com.lzy.project.dao")
// 启用Feign客户端，用于声明式REST调用
@EnableFeignClients
// 启用数据源代理自动配置，可能用于日志记录、事务管理等
@EnableAutoDataSourceProxy
// 标记为Spring Boot应用的主类
@SpringBootApplication
public class ProjectApplication {
    // 主函数，应用入口
    public static void main(String[] args) {
        // 运行Spring Boot应用
        SpringApplication.run(ProjectApplication.class, args);
    }
}
