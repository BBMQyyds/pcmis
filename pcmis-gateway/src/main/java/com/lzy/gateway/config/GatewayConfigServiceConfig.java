package com.lzy.gateway.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 配置服务配置类，用于初始化和提供ConfigService实例
 */
@Configuration
public class GatewayConfigServiceConfig {

    /**
     * 网关路由配置属性，用于获取命名空间等配置信息
     */
    @Autowired
    private GatewayRouteConfigProperties configProperties;

    /**
     * Nacos配置属性，用于获取Nacos服务器地址等配置信息
     */
    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    /**
     * 创建并返回一个ConfigService实例
     *
     * @return ConfigService实例，用于与Nacos配置中心进行交互
     * @throws NacosException 如果创建过程中出现错误，会抛出NacosException
     */
    @Bean
    public ConfigService configService() throws NacosException {
        // 初始化属性集合，用于设置ConfigService的配置信息
        Properties properties = new Properties();
        // 设置Nacos服务器地址
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosConfigProperties.getServerAddr());
        // 设置命名空间
        properties.setProperty(PropertyKeyConst.NAMESPACE, configProperties.getNamespace());
        // 根据配置信息创建并返回ConfigService实例
        return NacosFactory.createConfigService(properties);
    }
}


