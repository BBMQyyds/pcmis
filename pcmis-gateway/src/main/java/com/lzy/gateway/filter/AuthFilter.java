package com.lzy.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=========================请求进入filter=========================");
        // 模拟token验证
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (!"token".equals(token)) {
            log.error("token验证失败...");
            return writeResponse(exchange.getResponse());
        }
        log.info("token验证成功...");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    protected Mono<Void> writeResponse(ServerHttpResponse response) {
        JSONObject message = new JSONObject();
        message.put("code", 401);
        message.put("msg", "token验证失败");
        byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.OK);
        // 指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}

