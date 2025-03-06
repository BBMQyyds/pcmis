package com.lzy.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

/**
 * 路由服务接口，用于定义和管理路由
 */
public interface RouteService {

    /**
     * 更新指定的路由定义
     *
     * @param routeDefinition 要更新的路由定义对象，包含路由的详细信息
     */
    void update(RouteDefinition routeDefinition);

    /**
     * 添加新的路由定义
     *
     * @param routeDefinition 要添加的路由定义对象，包含路由的详细信息
     */
    void add(RouteDefinition routeDefinition);
}


