package com.lzy.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayParamFlowItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import com.alibaba.csp.sentinel.config.SentinelConfig;
import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import com.lzy.gateway.handler.OpenBlockRequestHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Configuration
public class SentinelGatewayConfiguration {

    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;
    @Autowired
    private InetUtils inetUtils;

    public SentinelGatewayConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                        ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        // Register the block exception handler for Spring Cloud Gateway.
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    /**
     * 自定义响应参数
     *
     * @return
     */
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public JsonSentinelGatewayBlockExceptionHandler jsonSentinelGatewayBlockExceptionHandler() {
//        return new JsonSentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
//    }
    @Bean
    @Order(-1)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }

    @PostConstruct
    public void doInit() {
        initGatewayRules();
        GatewayCallbackManager.setBlockHandler(new OpenBlockRequestHandler());
        //设置监控ip(多网卡时默认获取有问题，所以需要采用springCloud网卡工具类)
        SentinelConfig.setConfig(TransportConfig.HEARTBEAT_CLIENT_IP, inetUtils.findFirstNonLoopbackAddress().getHostAddress());
    }

    /**
     * 初始化路由规则
     */
    private void initGatewayRules() {
        Set<GatewayFlowRule> rules = new HashSet<>();

        //限制每个ip每秒只能调用5次，
        //setBurst突发请求额外增加5个
        rules.add(new GatewayFlowRule("open_gateway")
                .setCount(5)
                .setIntervalSec(1)
                .setBurst(5)
                .setParamItem(new GatewayParamFlowItem()
                        .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_CLIENT_IP)
                )
        );

        //限制一个应用appId每秒只能调用5次
        //setBurst突发请求额外增加5个
        rules.add(new GatewayFlowRule("open_gateway")
                .setCount(5)
                .setIntervalSec(1)
                .setBurst(5)
                .setParamItem(new GatewayParamFlowItem()
                        .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                        .setFieldName("appId")
                )
        );

        //限制一个应用appId每秒只能调用5次
        //setBurst突发请求额外增加5个
        rules.add(new GatewayFlowRule("open_gateway")
                .setCount(5)
                .setIntervalSec(1)
                .setBurst(5)
                .setParamItem(new GatewayParamFlowItem()
                        .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                        .setFieldName("appId").setPattern("testApp")
                )
        );

        GatewayRuleManager.loadRules(rules);
    }
}