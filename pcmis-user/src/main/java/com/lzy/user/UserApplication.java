package com.lzy.user;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

// 导入多个配置类，用于初始化应用上下文
@Import({
        com.lzy.common.config.DruidDataSourceConfig.class, // 配置Druid数据源
        com.lzy.common.config.MybatisPlusConfig.class, // 配置MyBatis Plus
        com.lzy.common.config.RedisConfig.class, // 配置Redis连接
        com.lzy.common.config.RedisUtilsConfig.class, // 配置Redis工具类
        com.lzy.common.config.JWTConfig.class, // 配置JWT认证
        com.lzy.common.config.SwaggerConfig.class // 配置Swagger文档
})
// 使用Spring Boot应用启动注解，排除自动配置的数据源以使用自定义配置
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
// 指定MyBatis Plus的Mapper接口所在包，自动扫描并注册
@MapperScan(basePackages = "com.lzy.user.dao")
// 启用Feign客户端，用于声明式REST调用
@EnableFeignClients
// 启用数据源代理，自动处理数据源切换等问题
@EnableAutoDataSourceProxy
// 标记为Spring Boot应用的主类
@SpringBootApplication
public class UserApplication {
    // 主函数，应用入口
    public static void main(String[] args) {
        // 运行Spring Boot应用
        SpringApplication.run(UserApplication.class, args);
    }
}
