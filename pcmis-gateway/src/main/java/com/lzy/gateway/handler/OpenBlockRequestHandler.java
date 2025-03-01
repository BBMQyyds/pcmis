package com.lzy.gateway.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.lzy.gateway.config.ResponseBean;
import com.lzy.gateway.util.ErrorCode;
import com.lzy.gateway.util.ResponseBeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class OpenBlockRequestHandler implements BlockRequestHandler {

    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable ex) {
        // JSON result by default.
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(buildErrorResult(ex)));
    }

    private ResponseBean buildErrorResult(Throwable ex) {
        // Return the error response bean from ResponseBeanUtils
        return ResponseBeanUtils.getResponseBean(ErrorCode.REQUEST_QPS_LIMIT_ERROR);
    }
}
