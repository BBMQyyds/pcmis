package com.lzy.gateway;

import com.lzy.gateway.util.BeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * GatewayApplication 类是网关服务的启动类
 * 它使用了Spring Boot的自动配置功能，并集成了Redis、JWT、Swagger等配置
 */
@Import({
    com.lzy.common.config.RedisConfig.class,
    com.lzy.common.config.RedisUtilsConfig.class,
    com.lzy.common.config.JWTConfig.class,
    com.lzy.common.config.SwaggerConfig.class,
})
@SpringBootApplication
@EnableFeignClients
@EnableOpenApi
public class GatewayApplication {
    /**
     * 主函数，用于启动Spring Boot应用
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);
        BeanUtil.set(context);
    }
}

