package com.lzy.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.lzy.common.util.JWTProvider;
import com.lzy.common.util.RedisUtils;
import com.lzy.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {


    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    RedisUtils redisUtils;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.prefix}")
    private String prefix;

    @Value("${allowed.paths}")
    private String paths;// 不需要验证的路径

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=========================请求进入filter=========================");

        ServerHttpRequest request = exchange.getRequest();
        String requestPath = request.getPath().toString();

        //swagger暴露v3/api-docs
        if (requestPath.contains("v3/api-docs") || requestPath.contains("v2/api-docs")) {
            return chain.filter(exchange);
        }

        boolean allowedPath = false;
        if (paths != null && !paths.isEmpty()) {
            allowedPath = StringUtils.checkSkipAuthUrls(requestPath, paths.split(","));
        }
        if (allowedPath || StringUtils.isEmpty(requestPath)) {
            return chain.filter(exchange);
        }

        // 验证token
        String authHeader = exchange.getRequest().getHeaders().getFirst(tokenHeader);
        if (authHeader != null && authHeader.startsWith(prefix)) {
            String authToken = authHeader.substring(prefix.length());
            authToken = authToken.trim();
            String userName = jwtProvider.getUserNameFromToken(authToken);

            // 查询redis
            Object token = redisUtils.get(userName);
            if (token == null) {
                log.error("token已过期...");
                return writeResponse(exchange.getResponse(), 401, "token验证失败或已过期...请重新登录");
            }

            String trimAuthToken = authToken.trim();
            if (!trimAuthToken.equals(token.toString())) {
                log.error("token验证失败...");
                return writeResponse(exchange.getResponse(), 401, "token验证失败或已过期...请重新登录");
            }
        } else {
            return writeResponse(exchange.getResponse(), 500, "token不存在");
        }

        log.info("token验证成功...");
        return chain.filter(exchange);
    }

    protected Mono<Void> writeResponse(ServerHttpResponse response, Integer code, String msg) {
        JSONObject message = new JSONObject();
        message.put("code", code);
        message.put("message", msg);
        byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.OK);
        // 指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
