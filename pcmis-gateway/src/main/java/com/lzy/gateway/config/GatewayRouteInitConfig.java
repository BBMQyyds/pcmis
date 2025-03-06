package com.lzy.gateway.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzy.common.util.StringUtils;
import com.lzy.gateway.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
/**
 * 网关路由初始化配置类
 * 用于在应用启动时初始化网关的动态路由配置
 */
@Component
@Slf4j
@RefreshScope
public class GatewayRouteInitConfig {

    // ObjectMapper用于JSON序列化和反序列化
    private final ObjectMapper objectMapper = new ObjectMapper();

    // 注入网关路由配置属性
    @Autowired
    private GatewayRouteConfigProperties configProperties;

    // 注入Nacos配置属性
    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    // 注入路由服务，用于更新和添加路由定义
    @Autowired
    private RouteService routeService;

    // 注入配置服务，用于获取配置信息
    @Autowired
    private ConfigService configService;

    /**
     * 在Bean创建后初始化网关路由配置
     * 该方法首先从配置中心获取当前的路由配置，然后解析并更新到路由服务中
     */
    @PostConstruct
    public void init() {
        log.info("开始网关动态路由初始化...");
        try {
            // getConfigAndSignListener()方法 发起长轮询和对dataId数据变更注册监听的操作
            // getConfig 只是发送普通的HTTP请求
            String initConfigInfo = configService.getConfigAndSignListener(configProperties.getDataId(), configProperties.getGroup(), nacosConfigProperties.getTimeout(), new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }

                @Override
                public void receiveConfigInfo(String configInfo) {
                    if (StringUtils.isNotEmpty(configInfo)) {
                        log.info("接收到网关路由更新配置：\r\n{}", configInfo);
                        List<RouteDefinition> routeDefinitions = null;
                        try {
                            // 解析接收到的配置信息为RouteDefinition列表
                            routeDefinitions = objectMapper.readValue(configInfo, new TypeReference<>() {
                            });
                        } catch (JsonProcessingException e) {
                            log.error("解析路由配置出错，" + e.getMessage(), e);
                        }
                        // 更新路由定义到路由服务中
                        for (RouteDefinition definition : Objects.requireNonNull(routeDefinitions)) {
                            routeService.update(definition);
                        }
                    } else {
                        log.warn("当前网关无动态路由相关配置");
                    }
                }
            });
            log.info("获取网关当前动态路由配置:\r\n{}", initConfigInfo);
            if (StringUtils.isNotEmpty(initConfigInfo)) {
                // 解析初始配置信息为RouteDefinition列表
                List<RouteDefinition> routeDefinitions = objectMapper.readValue(initConfigInfo, new TypeReference<>() {
                });
                // 添加路由定义到路由服务中
                for (RouteDefinition definition : routeDefinitions) {
                    routeService.add(definition);
                }
            } else {
                log.warn("当前网关无动态路由相关配置");
            }
            log.info("结束网关动态路由初始化...");
        } catch (Exception e) {
            log.error("初始化网关路由时发生错误", e);
        }
    }

}


