package com.lzy.gateway.service.impl;

import com.lzy.gateway.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * RouteServiceImpl类实现了RouteService接口和ApplicationEventPublisherAware接口，
 * 提供了路由定义的更新和添加功能，并能够在更改后发布事件以刷新路由。
 */
@Service
@Slf4j
public class RouteServiceImpl implements RouteService, ApplicationEventPublisherAware {

    // 注入RouteDefinitionWriter，用于操作路由定义
    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    // 应用事件发布器，用于发布刷新路由的事件
    private ApplicationEventPublisher publisher;

    /**
     * 更新路由定义。
     * 首先删除现有的路由定义，然后保存新的路由定义，并发布刷新路由的事件。
     *
     * @param routeDefinition 要更新的路由定义
     */
    @Override
    public void update(RouteDefinition routeDefinition) {
        log.info("更新路由配置项：{}", routeDefinition);
        this.routeDefinitionWriter.delete(Mono.just(routeDefinition.getId()));
        routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    /**
     * 添加新的路由定义，并发布刷新路由的事件。
     *
     * @param routeDefinition 要添加的路由定义
     */
    @Override
    public void add(RouteDefinition routeDefinition) {
        log.info("新增路由配置项：{}", routeDefinition);
        routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    /**
     * 设置应用事件发布器，实现ApplicationEventPublisherAware接口。
     *
     * @param applicationEventPublisher 应用事件发布器
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}


