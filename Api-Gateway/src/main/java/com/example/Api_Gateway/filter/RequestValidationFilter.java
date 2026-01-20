package com.example.Api_Gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class RequestValidationFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("filter () called....");
//        TODO : Logic to validate the request

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        Set<String> keySet = headers.toSingleValueMap().keySet();

        if(!keySet.contains("SecretToken")){
            throw new RuntimeException("invalid request");
        }

        List<String> secretTokenList = headers.get("SecretToken");

        if(!secretTokenList.get(0).equals("kashif@123")){
            throw new RuntimeException("invalid request");
        }
        return chain.filter(exchange);
    }
}
