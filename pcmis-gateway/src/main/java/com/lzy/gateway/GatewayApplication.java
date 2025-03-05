package com.lzy.gateway;

import com.lzy.gateway.util.BeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import springfox.documentation.oas.annotations.EnableOpenApi;

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
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);
        BeanUtil.set(context);
    }
}
