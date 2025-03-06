package com.lzy.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置类，用于管理网关路由的配置属性
 * 该类使用@ConfigurationProperties注解来绑定配置文件中以'gateway.routes.config'为前缀的属性
 * 使用@Component将其注册为Spring容器中的一个组件
 * 使用@Data自动生成getter和setter方法，简化编码
 */
@ConfigurationProperties(prefix = "gateway.routes.config")
@Component
@Data
public class GatewayRouteConfigProperties {

    /**
     * 配置项的Data ID，用于唯一标识配置内容
     * 在配置中心如Nacos、Spring Cloud Config中，Data ID是获取配置的关键
     */
    private String dataId;

    /**
     * 配置项所属的组
     * 用于在配置中心区分不同的配置分组，有助于配置的管理和部署
     */
    private String group;

    /**
     * 配置项的命名空间
     * 命名空间用于隔离不同环境或应用的配置，避免配置冲突
     */
    private String namespace;
}
