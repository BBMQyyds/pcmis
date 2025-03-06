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

/**
 * Handles open block requests, implementing the BlockRequestHandler interface.
 * This class is responsible for processing requests when the system is under high load or encounters specific exceptions,
 * returning a unified response result.
 */
public class OpenBlockRequestHandler implements BlockRequestHandler {

    /**
     * Processes the request and returns a response.
     * This method overrides the handleRequest method of the BlockRequestHandler interface, used to handle high load or exceptional situations,
     * returning a JSON formatted response result.
     *
     * @param exchange The server web exchange, containing request and response information.
     * @param ex       The exception thrown, used to build the error response.
     * @return Returns a Mono object containing the server's response.
     */
    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable ex) {
        // JSON result by default.
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(buildErrorResult(ex)));
    }

    /**
     * Builds the error response result.
     * This method is used to generate a unified error response when the system encounters an exception,
     * returning a ResponseBean object containing the error information.
     *
     * @param ex The exception thrown, used to generate the error response.
     * @return Returns the error response bean.
     */
    private ResponseBean buildErrorResult(Throwable ex) {
        // Return the error response bean from ResponseBeanUtils
        return ResponseBeanUtils.getResponseBean(ErrorCode.REQUEST_QPS_LIMIT_ERROR);
    }
}

